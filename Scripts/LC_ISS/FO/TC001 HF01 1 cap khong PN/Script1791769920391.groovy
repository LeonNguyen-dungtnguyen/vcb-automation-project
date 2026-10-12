// TC No 1 (row 2) – HF-01: Tạo mới → Gửi duyệt → KT trưởng duyệt (2FA) → Chủ TK ký số → Đã gửi ngân hàng. 1 cấp duyệt, không ký số pháp nhân.
// Run with profile SIT_LC.

import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.FoRole
import com.vcb.lc.enums.ReturnRejectAction
import com.vcb.lc.keywords.FoBusinessKeywords as FO
import com.vcb.lc.keywords.SharedBusinessKeywords as Shared
import com.vcb.lc.model.ApprovalSetup
import com.vcb.lc.model.LcRequestData
import com.vcb.lc.support.LcConfig

ApprovalSetup setup = ApprovalSetup.ONE_LEVEL_NO_PN
LcRequestData data = LcRequestData.fromDataFile('Data Files/LC_ISS/LcRequest_Minimal', 1)

try {
	// 1. Maker login, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ, đính kèm hồ sơ
	FO.loginFo(FoRole.MAKER)
	FO.createLcRequest(data, setup)
	Shared.uploadDocument(LcConfig.get('G_lcSampleAttachment'))
	// 2. Đẩy giao dịch lên cấp duyệt → "Chờ duyệt"
	FO.submitForApproval(data)
	// 3. Kế toán trưởng login, xác thực 2FA và Phê duyệt
	FO.loginFo(FoRole.KE_TOAN_TRUONG)
	FO.approveWith2fa(data.requestCode, FoRole.KE_TOAN_TRUONG, setup)
	// 4. Chủ tài khoản login, Ký số thành công → "Đã gửi ngân hàng"
	FO.loginFo(FoRole.CHU_TAI_KHOAN)
	FO.signPersonal(data.requestCode, setup)
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
