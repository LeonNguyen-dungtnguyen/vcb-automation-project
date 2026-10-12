// TC No 27 (row 28) – BO Happy case 1: CA xử lý → CA lead duyệt → CRC xử lý → CRC lead duyệt & ký số điện → TI → Hoàn thành. Không cần thẩm quyền BGĐ CN, điện không ký số, không chuyển khẩu/tạm nhập tái xuất.
// Run with profile SIT_LC.

import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.BoFileType
import com.vcb.lc.enums.BoProposal
import com.vcb.lc.enums.BoRole
import com.vcb.lc.enums.BoSaveAction
import com.vcb.lc.enums.BoStatus
import com.vcb.lc.keywords.BoBusinessKeywords as BO
import com.vcb.lc.keywords.SharedBusinessKeywords as Shared
import com.vcb.lc.model.ApprovalSetup
import com.vcb.lc.model.LcRequestData

LcRequestData data = LcRequestData.fromDataFile('Data Files/LC_ISS/LcRequest_Minimal', 1)
// TODO: field labels / values of Thông tin xử lý (BO_happy_cases.md)
Map<String, String> processingInfo = [:]

try {
	// Tiền đề: đề nghị FO đã gửi sang BO, TT trên BO = Chờ tiếp nhận
	String requestCode = BO.prepareRequestSentToBo(data, ApprovalSetup.ONE_LEVEL_NO_PN)
	// CA đăng nhập BO → Danh sách (tab Cần xử lý) → chọn giao dịch → nhấn <Tiếp nhận>
	BO.loginBo(BoRole.CA)
	BO.caReceive(requestCode)
	Shared.viewOrDownloadFile(BoFileType.FILE_TAC_NGHIEP)
	// CA nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>
	BO.enterProcessingInfo(BoRole.CA, BoProposal.APPROVE, processingInfo)
	BO.saveOrSubmit(BoRole.CA, BoSaveAction.SUBMIT)
	// CA lead mở giao dịch (TT = QLTĐ phê duyệt) → nhấn <Phê duyệt>
	BO.loginBo(BoRole.CA_LEAD)
	BO.leaderApprove(requestCode, BoRole.CA_LEAD, false)
	// CRC mở giao dịch (TT = CB QLN xử lý), nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → <Gửi duyệt>
	BO.loginBo(BoRole.CRC)
	BO.openTransactionByStatus(requestCode, BoStatus.CB_QLN_XU_LY)
	BO.enterProcessingInfo(BoRole.CRC, BoProposal.APPROVE, processingInfo)
	BO.saveOrSubmit(BoRole.CRC, BoSaveAction.SUBMIT)
	// CRC lead phê duyệt (1) – không thuộc thẩm quyền BGĐ CN, ký số điện phát hành
	BO.loginBo(BoRole.CRC_LEAD)
	BO.leaderApprove(requestCode, BoRole.CRC_LEAD, false)
	BO.signIssuanceMessage(requestCode, BoRole.CRC_LEAD)
	// Hệ thống TI trả kết quả điện phát hành MT700 về BO → Hoàn thành
	BO.verifyTiResult(requestCode, false)
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
