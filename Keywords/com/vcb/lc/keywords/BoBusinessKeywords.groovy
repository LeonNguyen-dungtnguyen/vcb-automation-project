package com.vcb.lc.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.BoProposal
import com.vcb.lc.enums.BoRole
import com.vcb.lc.enums.BoSaveAction
import com.vcb.lc.enums.BoStatus
import com.vcb.lc.enums.FoRole
import com.vcb.lc.enums.ReturnRejectAction
import com.vcb.lc.model.ApprovalSetup
import com.vcb.lc.model.LcRequestData
import com.vcb.lc.support.LcConfig
import com.vcb.lc.support.SecurityStepHandler
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.lc.bo.WebBoLoginPage
import com.vcb.m2u.internal.pages.base.lc.bo.WebBoProcessingForm
import com.vcb.m2u.internal.pages.base.lc.bo.WebBoReassignPopup
import com.vcb.m2u.internal.pages.base.lc.bo.WebBoTransactionDetailPage
import com.vcb.m2u.internal.pages.base.lc.bo.WebBoTransactionListPage
import com.vcb.m2u.internal.pages.base.lc.common.WebNotification
import com.vcb.m2u.internal.pages.base.lc.common.WebReasonPopup

/**
 * BO business keywords – one keyword per BO composite step of requirements/LC_ISS/COMPOSITE_STEPS.md:
 *  #11 prepareRequestSentToBo  – Tiền đề: đề nghị FO đã gửi sang BO (Chờ tiếp nhận)
 *  #12 loginBo                 – Login BO theo vai trò
 *  #13 openTransactionByStatus – Truy vấn / mở giao dịch theo trạng thái
 *  #14 caReceive               – CA tiếp nhận
 *  #15 enterProcessingInfo     – Nhập thông tin xử lý tác nghiệp + chọn đề xuất (1)/(2)
 *  #16 saveOrSubmit            – Lưu / Gửi duyệt
 *  #17 leaderApprove           – Lãnh đạo phê duyệt (CA lead / CRC lead / BGĐ CN)
 *  #18 boReturnOrReject        – Trả lại / Từ chối
 *  #19 reassign                – Phân công lại
 *  #20 signIssuanceMessage     – Ký số điện phát hành LC
 *  #21 verifyTiResult          – TI trả kết quả / đẩy sang TI
 */
public class BoBusinessKeywords extends WebUIKeyword {

	static final String TAB_TO_PROCESS = 'Cần xử lý'
	static final int MAX_REASON_LENGTH = 2000

	/**
	 * #11 Run the FO chain until the request reaches Đã gửi ngân hàng (BO status Chờ tiếp nhận).
	 * @return the request code
	 */
	@Keyword
	static String prepareRequestSentToBo(LcRequestData data, ApprovalSetup setup, FailureHandling flowControl = defaultFailureHandling) {
		FoBusinessKeywords.loginFo(FoRole.MAKER, flowControl)
		FoBusinessKeywords.createLcRequest(data, setup, flowControl)
		FoBusinessKeywords.submitForApproval(data, flowControl)
		if (setup.levels == 2) {
			FoBusinessKeywords.loginFo(FoRole.KE_TOAN_PHO, flowControl)
			FoBusinessKeywords.approveWith2fa(data.requestCode, FoRole.KE_TOAN_PHO, setup, flowControl)
		}
		FoBusinessKeywords.loginFo(FoRole.KE_TOAN_TRUONG, flowControl)
		FoBusinessKeywords.approveWith2fa(data.requestCode, FoRole.KE_TOAN_TRUONG, setup, flowControl)
		FoBusinessKeywords.loginFo(FoRole.CHU_TAI_KHOAN, flowControl)
		FoBusinessKeywords.signPersonal(data.requestCode, setup, flowControl)
		if (setup.companySignature) {
			FoBusinessKeywords.loginFo(FoRole.NGUOI_KY_PHAP_NHAN, flowControl)
			FoBusinessKeywords.signCompany(data.requestCode, flowControl)
		}
		// BO now shows the request in status Chờ tiếp nhận
		return data.requestCode
	}

	/**
	 * #12 Login BO with the test user of the role (logs out the current user first).
	 */
	@Keyword
	static void loginBo(BoRole role, FailureHandling flowControl = defaultFailureHandling) {
		info "Login BO as ${role.label}"
		WebBoLoginPage loginPage = WebBasePage.getPage(WebBoLoginPage)
		if (loginPage.isLoggedIn()) {
			loginPage.logout(flowControl)
		}
		loginPage.open(LcConfig.get('G_boUrl'), flowControl)
		loginPage.login(LcConfig.get(role.userVar), LcConfig.get(role.passwordVar), flowControl)
	}

	/**
	 * #13 Open the transaction from the list tab and check it is in the expected status.
	 */
	@Keyword
	static void openTransactionByStatus(String requestCode, BoStatus status, String tab = TAB_TO_PROCESS, FailureHandling flowControl = defaultFailureHandling) {
		WebBoTransactionListPage list = WebBasePage.getPage(WebBoTransactionListPage)
		list.openTab(tab, flowControl)
		list.openByRequestCode(requestCode, flowControl)
		WebBasePage.getPage(WebBoTransactionDetailPage).verifyStatus(status.label, flowControl)
	}

	/**
	 * #14 CA opens the transaction in Chờ tiếp nhận and presses Tiếp nhận → CBTĐ xử lý.
	 */
	@Keyword
	static void caReceive(String requestCode, FailureHandling flowControl = defaultFailureHandling) {
		openTransactionByStatus(requestCode, BoStatus.CHO_TIEP_NHAN, TAB_TO_PROCESS, flowControl)
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		detail.clickAction(detail.btnReceive(), flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		detail.verifyStatus(BoStatus.CBTD_XU_LY.label, flowControl)
	}

	/**
	 * #15 CA / CRC fills Thông tin xử lý and chooses Đề xuất (1) phê duyệt / (2) từ chối.
	 * Precondition: the transaction is open (#13 or #14).
	 */
	@Keyword
	static void enterProcessingInfo(BoRole role, BoProposal proposal, Map<String, String> processingInfo, FailureHandling flowControl = defaultFailureHandling) {
		if (role != BoRole.CA && role != BoRole.CRC) {
			throw new IllegalArgumentException("Only CA or CRC enter processing info, got ${role.label}")
		}
		WebBoProcessingForm form = WebBasePage.getPage(WebBoProcessingForm)
		form.fillInfo(processingInfo, flowControl)
		form.selectProposal(proposal, flowControl)
	}

	/**
	 * #16 Lưu, or Gửi duyệt (→ the next approval status of the role).
	 */
	@Keyword
	static void saveOrSubmit(BoRole role, BoSaveAction action, FailureHandling flowControl = defaultFailureHandling) {
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		detail.clickAction(action == BoSaveAction.SAVE ? detail.btnSave() : detail.btnSubmit(), flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		if (action == BoSaveAction.SUBMIT) {
			detail.verifyStatus(BoStatus.afterSubmit(role).label, flowControl)
		}
	}

	/**
	 * #17 CA lead / CRC lead / BGĐ CN approves. When the transaction needs BGĐ CN authority,
	 * the lead ticks "gửi duyệt BGĐ CN" before approving.
	 */
	@Keyword
	static void leaderApprove(String requestCode, BoRole leader, boolean needsBgdCnAuthority, FailureHandling flowControl = defaultFailureHandling) {
		openTransactionByStatus(requestCode, BoStatus.awaitingApprovalBy(leader), TAB_TO_PROCESS, flowControl)
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		if (needsBgdCnAuthority && leader != BoRole.BGD_CN) {
			WebUIKeyword.click(detail.chkSendToBgdCn(), flowControl)
		}
		detail.clickAction(detail.btnApprove(), flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
		detail.verifyStatus(BoStatus.afterLeaderApproval(leader, needsBgdCnAuthority).label, flowControl)
	}

	/**
	 * #18 Trả lại / Từ chối with a reason (mandatory, max 2000 characters).
	 * Precondition: the transaction is open (#13). TO CONFIRM on SIT: resulting status per role.
	 */
	@Keyword
	static void boReturnOrReject(String requestCode, BoRole role, ReturnRejectAction action, String reason, FailureHandling flowControl = defaultFailureHandling) {
		if (!reason || reason.length() > MAX_REASON_LENGTH) {
			throw new IllegalArgumentException("Reason is mandatory and at most ${MAX_REASON_LENGTH} characters")
		}
		info "${role.label} ${action.label} transaction ${requestCode}"
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		detail.clickAction(action == ReturnRejectAction.RETURN ? detail.btnReturn() : detail.btnReject(), flowControl)
		WebBasePage.getPage(WebReasonPopup).enterReasonAndConfirm(reason, flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
	}

	/**
	 * #19 Phân công lại the open transaction to another user.
	 * Precondition: the transaction is open (#13).
	 */
	@Keyword
	static void reassign(String requestCode, String targetUser, FailureHandling flowControl = defaultFailureHandling) {
		info "Reassign transaction ${requestCode} to ${targetUser}"
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		detail.clickAction(detail.btnReassign(), flowControl)
		WebBasePage.getPage(WebBoReassignPopup).reassignTo(targetUser, flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
	}

	/**
	 * #20 CRC lead (LĐ QLN) or BGĐ CN signs the LC issuance message (điện phát hành).
	 * Precondition: the transaction is open (#13).
	 */
	@Keyword
	static void signIssuanceMessage(String requestCode, BoRole signer, FailureHandling flowControl = defaultFailureHandling) {
		if (signer != BoRole.CRC_LEAD && signer != BoRole.BGD_CN) {
			throw new IllegalArgumentException("Only CRC lead or BGĐ CN sign the issuance message, got ${signer.label}")
		}
		info "${signer.label} signs the issuance message of ${requestCode}"
		WebBoTransactionDetailPage detail = WebBasePage.getPage(WebBoTransactionDetailPage)
		detail.clickAction(detail.btnSign(), flowControl)
		SecurityStepHandler.completeDigitalSignature(signer.label, flowControl)
		WebBasePage.getPage(WebNotification).waitForSuccess(flowControl)
	}

	/**
	 * #21 After TI (external system) returns the MT700 message, check the final BO status:
	 * Hoàn thành, or Hoàn thành - Chờ bổ sung hồ sơ for chuyển khẩu / tạm nhập tái xuất.
	 */
	@Keyword
	static void verifyTiResult(String requestCode, boolean awaitingDocuments, FailureHandling flowControl = defaultFailureHandling) {
		WebBasePage.getPage(WebBoTransactionListPage).openByRequestCode(requestCode, flowControl)
		BoStatus expected = awaitingDocuments ? BoStatus.HOAN_THANH_CHO_BO_SUNG : BoStatus.HOAN_THANH
		WebBasePage.getPage(WebBoTransactionDetailPage).verifyStatus(expected.label, flowControl)
	}
}
