// TC No 5 (row 6) – HF-02: Tạo mới → Lưu nháp → Mở lại, Gửi duyệt → Duyệt → Ký số cá nhân → Ký số pháp nhân → Đã gửi ngân hàng. 1 cấp duyệt, có ký số pháp nhân.
// Run with profile SIT_LC.

import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.FoRole
import com.vcb.lc.enums.ReturnRejectAction
import com.vcb.lc.keywords.FoBusinessKeywords as FO
import com.vcb.lc.keywords.SharedBusinessKeywords as Shared
import com.vcb.lc.model.ApprovalSetup
import com.vcb.lc.model.LcRequestData
import com.vcb.lc.support.LcConfig

ApprovalSetup setup = ApprovalSetup.ONE_LEVEL_WITH_PN
LcRequestData data = LcRequestData.fromDataFile('Data Files/LC_ISS/LcRequest_Minimal', 1)

try {
	// 1. Maker thêm mới, nhập liệu, Lưu nháp → "Bản nháp"
	FO.loginFo(FoRole.MAKER)
	FO.createLcRequest(data, setup)
	FO.saveDraft(data)
	// 2. Maker mở lại bản ghi vừa lưu nháp, đẩy lên cấp duyệt → "Chờ duyệt"
	FO.reopenAndEdit(data.requestCode, new LcRequestData())
	FO.submitForApproval(data)
	// 3. Kế toán trưởng xác thực 2FA và Phê duyệt
	FO.loginFo(FoRole.KE_TOAN_TRUONG)
	FO.approveWith2fa(data.requestCode, FoRole.KE_TOAN_TRUONG, setup)
	// 4. Chủ tài khoản Ký số → "Chờ ký số pháp nhân"
	FO.loginFo(FoRole.CHU_TAI_KHOAN)
	FO.signPersonal(data.requestCode, setup)
	// 5. Người ký pháp nhân Ký số pháp nhân → "Đã gửi ngân hàng"
	FO.loginFo(FoRole.NGUOI_KY_PHAP_NHAN)
	FO.signCompany(data.requestCode)
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
