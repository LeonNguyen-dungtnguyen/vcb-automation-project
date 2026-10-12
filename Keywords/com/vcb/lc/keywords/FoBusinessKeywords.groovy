package com.vcb.lc.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.CancelDeleteAction
import com.vcb.lc.enums.FoRole
import com.vcb.lc.enums.FoStatus
import com.vcb.lc.enums.ReturnRejectAction
import com.vcb.lc.model.ApprovalSetup
import com.vcb.lc.model.LcRequestData
import com.vcb.lc.support.LcConfig
import com.vcb.lc.support.SecurityStepHandler
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.lc.common.WebConfirmPopup
import com.vcb.m2u.internal.pages.base.lc.common.WebNotification
import com.vcb.m2u.internal.pages.base.lc.common.WebOtpPopup
import com.vcb.m2u.internal.pages.base.lc.common.WebReasonPopup
import com.vcb.m2u.internal.pages.base.lc.fo.WebFoLcDetailPage
import com.vcb.m2u.internal.pages.base.lc.fo.WebFoLcListPage
import com.vcb.m2u.internal.pages.base.lc.fo.WebFoLcWizardPage
import com.vcb.m2u.internal.pages.base.lc.fo.WebFoLoginPage
import com.vcb.m2u.internal.pages.base.lc.fo.WebFoMenuPage

import internal.GlobalVariable

/**
 * FO business keywords – one keyword per FO composite step of requirements/LC_ISS/COMPOSITE_STEPS.md:
 *  #1 loginFo            – Login FO theo vai trò
 *  #2 createLcRequest    – Thêm mới đề nghị LC + nhập liệu đầy đủ
 *  #3 saveDraft          – Lưu nháp
 *  #4 submitForApproval  – Gửi duyệt / đẩy lên cấp duyệt / gửi lại
 *  #5 approveWith2fa     – Phê duyệt + xác thực 2FA (OTP)
 *  #6 signPersonal       – Ký số cá nhân
 *  #7 signCompany        – Ký số pháp nhân
 *  #8 returnOrReject     – Trả lại / Từ chối
 *  #9 cancelOrDelete     – Hủy / Xóa đề nghị
 *  #10 reopenAndEdit     – Mở lại & chỉnh sửa bản ghi
 */
public class FoBusinessKeywords extends WebUIKeyword {

	/**
	 * #1 Login FO with the test user of the role (logs out the current user first).
	 */
	@Keyword
	static void loginFo(FoRole role, FailureHandling flowControl = defaultFailureHandling) {
		info "Login FO as ${role.label}"
		WebFoMenuPage menu = WebBasePage.getPage(WebFoMenuPage)
		if (menu.isLoggedIn()) {
			menu.logout(flowControl)
		}
		WebFoLoginPage loginPage = WebBasePage.getPage(WebFoLoginPage)
		loginPage.open(LcConfig.get('G_foUrl'), flowControl)
		loginPage.login(LcConfig.get(role.userVar), LcConfig.get(role.passwordVar), flowControl)
	}

	/**
	 * #2 Maker opens Thêm mới and fills the wizard with the test data.
	 * The approval setup is configured on the test users (not in the wizard); it is passed for traceability only.
	 * @return the request code if the wizard already shows it, otherwise null (set later by #3 / #4)
	 */
	@Keyword
	static String createLcRequest(LcRequestData data, ApprovalSetup setup, FailureHandling flowControl = defaultFailureHandling) {
		info "Create LC request (${setup})"
		WebBasePage.getPage(WebFoMenuPage).goTo(WebFoMenuPage.MENU_LC_ISSUANCE, flowControl)
		WebBasePage.getPage(WebFoLcListPage).openCreateNew(flowControl)
		WebFoLcWizardPage wizard = WebBasePage.getPage(WebFoLcWizardPage)
		wizard.fillAll(data, flowControl)
		data.requestCode = wizard.getRequestCode() ?: data.requestCode
		return data.requestCode
	}

	/**
	 * #3 Lưu nháp from the wizard → Bản nháp.
	 */
	@Keyword
	static void saveDraft(LcRequestData data, FailureHandling flowControl = defaultFailureHandling) {
		WebFoLcWizardPage wizard = WebBasePage.getPage(WebFoLcWizardPage)
		WebUIKeyword.click(wizard.btnSaveDraft(), flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		data.requestCode = wizard.getRequestCode() ?: data.requestCode
		verifyRequestStatus(data.requestCode, FoStatus.BAN_NHAP, flowControl)
	}

	/**
	 * #4 Gửi duyệt from the wizard or the detail screen (also "gửi lại" after editing) → Chờ duyệt.
	 */
	@Keyword
	static void submitForApproval(LcRequestData data, FailureHandling flowControl = defaultFailureHandling) {
		WebFoLcWizardPage wizard = WebBasePage.getPage(WebFoLcWizardPage)
		data.requestCode = wizard.getRequestCode() ?: data.requestCode
		if (waitForElementPresent(wizard.btnSubmit(), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)) {
			WebUIKeyword.click(wizard.btnSubmit(), flowControl)
		} else {
			WebFoLcDetailPage detail = WebBasePage.getPage(WebFoLcDetailPage)
			detail.clickAction(detail.btnSubmit(), flowControl)
		}
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		verifyRequestStatus(data.requestCode, FoStatus.CHO_DUYET, flowControl)
	}

	/**
	 * #5 Kế toán phó / Kế toán trưởng approves with 2FA.
	 */
	@Keyword
	static void approveWith2fa(String requestCode, FoRole approver, ApprovalSetup setup, FailureHandling flowControl = defaultFailureHandling) {
		if (approver != FoRole.KE_TOAN_PHO && approver != FoRole.KE_TOAN_TRUONG) {
			throw new IllegalArgumentException("Only Kế toán phó / Kế toán trưởng approve, got ${approver.label}")
		}
		WebFoLcDetailPage detail = openRequest(requestCode, flowControl)
		detail.clickAction(detail.btnApprove(), flowControl)
		confirmWithOtp(flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		verifyRequestStatus(requestCode, FoStatus.afterApproval(approver, setup), flowControl)
	}

	/**
	 * #6 Chủ tài khoản signs (Ký số cá nhân) → Chờ ký số pháp nhân / Đã gửi ngân hàng.
	 */
	@Keyword
	static void signPersonal(String requestCode, ApprovalSetup setup, FailureHandling flowControl = defaultFailureHandling) {
		WebFoLcDetailPage detail = openRequest(requestCode, flowControl)
		detail.clickAction(detail.btnSign(), flowControl)
		SecurityStepHandler.completeDigitalSignature(FoRole.CHU_TAI_KHOAN.label, flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		verifyRequestStatus(requestCode, FoStatus.afterPersonalSignature(setup), flowControl)
	}

	/**
	 * #7 Người ký pháp nhân signs from the Ký số pháp nhân menu → Đã gửi ngân hàng.
	 */
	@Keyword
	static void signCompany(String requestCode, FailureHandling flowControl = defaultFailureHandling) {
		WebBasePage.getPage(WebFoMenuPage).goTo(WebFoMenuPage.MENU_COMPANY_SIGNATURE, flowControl)
		WebBasePage.getPage(WebFoLcListPage).openRequest(requestCode, null, flowControl)
		WebFoLcDetailPage detail = WebBasePage.getPage(WebFoLcDetailPage)
		detail.clickAction(detail.btnSign(), flowControl)
		SecurityStepHandler.completeDigitalSignature(FoRole.NGUOI_KY_PHAP_NHAN.label, flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		verifyRequestStatus(requestCode, FoStatus.DA_GUI_NGAN_HANG, flowControl)
	}

	/**
	 * #8 Trả lại (Kế toán phó / trưởng) or Từ chối (Kế toán trưởng / Chủ tài khoản) with a reason.
	 * Ký số pháp nhân has no Từ chối button (TC12), so Người ký pháp nhân is not allowed.
	 */
	@Keyword
	static void returnOrReject(String requestCode, FoRole role, ReturnRejectAction action, String reason, FailureHandling flowControl = defaultFailureHandling) {
		List<FoRole> allowed = action == ReturnRejectAction.RETURN ?
				[FoRole.KE_TOAN_PHO, FoRole.KE_TOAN_TRUONG] :
				[FoRole.KE_TOAN_TRUONG, FoRole.CHU_TAI_KHOAN]
		if (!allowed.contains(role)) {
			throw new IllegalArgumentException("${role.label} cannot ${action.label}")
		}
		WebFoLcDetailPage detail = openRequest(requestCode, flowControl)
		detail.clickAction(action == ReturnRejectAction.RETURN ? detail.btnReturn() : detail.btnReject(), flowControl)
		WebBasePage.getPage(WebReasonPopup).enterReasonAndConfirm(reason, flowControl)
		if (action == ReturnRejectAction.REJECT) {
			// Từ chối also asks for 2FA (FO_automation_blockers.md §1)
			confirmWithOtp(flowControl)
		}
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		verifyRequestStatus(requestCode, FoStatus.afterReturnOrReject(role, action), flowControl)
	}

	/**
	 * #9 Maker cancels (→ Đã hủy) or deletes (→ removed from the list) a request.
	 */
	@Keyword
	static void cancelOrDelete(String requestCode, CancelDeleteAction action, FailureHandling flowControl = defaultFailureHandling) {
		WebFoLcDetailPage detail = openRequest(requestCode, flowControl)
		detail.clickAction(action == CancelDeleteAction.CANCEL ? detail.btnCancelRequest() : detail.btnDeleteRequest(), flowControl)
		WebBasePage.getPage(WebConfirmPopup).confirm(flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		if (action == CancelDeleteAction.CANCEL) {
			verifyRequestStatus(requestCode, FoStatus.DA_HUY, flowControl)
			return
		}
		WebBasePage.getPage(WebFoMenuPage).goTo(WebFoMenuPage.MENU_LC_ISSUANCE, flowControl)
		if (WebBasePage.getPage(WebFoLcListPage).isRequestListed(requestCode)) {
			handleError("Request ${requestCode} is still listed after ${action.label}", flowControl)
		}
	}

	/**
	 * #10 Maker reopens a request in Bản nháp / Yêu cầu chỉnh sửa and applies the changes.
	 * Send it again with #4 submitForApproval.
	 */
	@Keyword
	static void reopenAndEdit(String requestCode, LcRequestData changes, FailureHandling flowControl = defaultFailureHandling) {
		WebFoLcDetailPage detail = openRequest(requestCode, flowControl)
		detail.clickAction(detail.btnEdit(), flowControl)
		changes.requestCode = requestCode
		WebBasePage.getPage(WebFoLcWizardPage).fillAll(changes, flowControl)
	}

	private static WebFoLcDetailPage openRequest(String requestCode, FailureHandling flowControl) {
		if (!requestCode) {
			handleError('Request code is unknown - TO CONFIRM where FO shows Mã đề nghị after saving', flowControl)
		}
		WebBasePage.getPage(WebFoMenuPage).goTo(WebFoMenuPage.MENU_LC_ISSUANCE, flowControl)
		WebBasePage.getPage(WebFoLcListPage).openRequest(requestCode, null, flowControl)
		return WebBasePage.getPage(WebFoLcDetailPage)
	}

	private static void verifyRequestStatus(String requestCode, FoStatus expected, FailureHandling flowControl) {
		info "Expect request ${requestCode} in status '${expected.label}'"
		openRequest(requestCode, flowControl).verifyStatus(expected.label, flowControl)
	}

	private static void confirmWithOtp(FailureHandling flowControl) {
		WebOtpPopup otpPopup = WebBasePage.getPage(WebOtpPopup)
		SecurityStepHandler.enterOtp(otpPopup.txtOtp(), flowControl)
		otpPopup.confirm(flowControl)
	}
}
