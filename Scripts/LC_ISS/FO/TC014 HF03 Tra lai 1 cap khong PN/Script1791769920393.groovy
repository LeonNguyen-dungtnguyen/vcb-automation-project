// TC No 14 (row 15) – HF-03: Tạo mới → Gửi duyệt → KT trưởng Trả lại (Yêu cầu chỉnh sửa) → Maker sửa, gửi lại → Duyệt → Ký số → Đã gửi ngân hàng. 1 cấp duyệt, không ký số pháp nhân.
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
	// 1. Maker thêm mới, nhập liệu đầy đủ, đẩy lên cấp duyệt → "Chờ duyệt"
	FO.loginFo(FoRole.MAKER)
	FO.createLcRequest(data, setup)
	FO.submitForApproval(data)
	// 2. Kế toán trưởng chọn <Trả lại>, nhập ý kiến, xác nhận → "Yêu cầu chỉnh sửa"
	FO.loginFo(FoRole.KE_TOAN_TRUONG)
	FO.returnOrReject(data.requestCode, FoRole.KE_TOAN_TRUONG, ReturnRejectAction.RETURN, 'Đề nghị bổ sung thông tin người thụ hưởng')
	// 3. Maker chỉnh sửa thông tin, gửi lại bản ghi → "Chờ duyệt"
	FO.loginFo(FoRole.MAKER)
	LcRequestData changes = new LcRequestData()
	changes.put('thongTinLc', 'diaChiNguoiThuHuong', 'TODO_UPDATED_ADDRESS')
	FO.reopenAndEdit(data.requestCode, changes)
	FO.submitForApproval(data)
	// 4. Kế toán trưởng duyệt, Chủ tài khoản ký số → "Đã gửi ngân hàng"
	FO.loginFo(FoRole.KE_TOAN_TRUONG)
	FO.approveWith2fa(data.requestCode, FoRole.KE_TOAN_TRUONG, setup)
	FO.loginFo(FoRole.CHU_TAI_KHOAN)
	FO.signPersonal(data.requestCode, setup)
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
