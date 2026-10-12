package com.vcb.m2u.internal.pages.base.lc.fo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.lc.model.LcRequestData
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * FO "Thêm mới đề nghị phát hành LC" wizard (also used when editing a request).
 * One fill method per wizard section S04–S15 (requirements/LC_ISS/FO/FO_flows.md §3).
 * Only the mandatory fields known today are implemented; other sections are extension points.
 */
public class WebFoLcWizardPage extends WebBasePage {

	/** Wizard sections in screen order. TO CONFIRM on SIT: one section per wizard step. */
	static final List<String> SECTION_ORDER = [
		'thongTinKhachHang',
		'thongTinLc',
		'giaTriLc',
		'thanhToan',
		'giaoHang',
		'dieuKhoanBoSung',
		'phi',
		'thongTinKhac',
		'chungTuYeuCau',
		'additionalConditions',
		'camKet',
		'dieuKhoan'
	]

	public static TestObject lblStepTitle(String stepName) {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/lblStepTitle', [stepName: stepName])
	}

	public static TestObject btnContinue() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/btnContinue')
	}

	public static TestObject btnBack() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/btnBack')
	}

	public static TestObject btnSaveDraft() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/btnSaveDraft')
	}

	public static TestObject btnSubmit() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/btnSubmit')
	}

	public static TestObject btnSaveTemplate() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/btnSaveTemplate')
	}

	public static TestObject lblRequestCode() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/lblRequestCode')
	}

	public static TestObject ddlLoaiLc() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/ddlLoaiLc')
	}

	public static TestObject ddlOption(String option) {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/ddlOption', [option: option])
	}

	public static TestObject txtNguoiThuHuong() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/txtNguoiThuHuong')
	}

	public static TestObject txtDiaChiNguoiThuHuong() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/txtDiaChiNguoiThuHuong')
	}

	public static TestObject txtNgayHetHan() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/txtNgayHetHan')
	}

	public static TestObject ddlLoaiTien() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/ddlLoaiTien')
	}

	public static TestObject txtSoTien() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/txtSoTien')
	}

	public static TestObject txtHuongDan() {
		return findTestObject('Object Repository/LC_ISS/FO/LcWizard/txtHuongDan')
	}

	/**
	 * Go through every wizard section in order, filling the sections present in data,
	 * and press Tiếp tục between sections. Stops on the last section (Lưu nháp / Gửi duyệt are separate keywords).
	 */
	void fillAll(LcRequestData data, FailureHandling flowControl = defaultFailureHandling) {
		SECTION_ORDER.eachWithIndex { String section, int index ->
			Map<String, String> fields = data.section(section)
			if (fields) {
				this."fill${section.capitalize()}"(fields, flowControl)
			}
			if (index < SECTION_ORDER.size() - 1) {
				WebUIKeyword.click(this.btnContinue(), flowControl)
			}
		}
	}

	// S04 – Thông tin khách hàng
	void fillThongTinKhachHang(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S04 (FO_flows.md, TC 233–246)
	}

	// S05 – Thông tin LC
	void fillThongTinLc(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		selectOption(this.ddlLoaiLc(), fields.loaiLc, flowControl)
		setTextIfPresent(this.txtNguoiThuHuong(), fields.nguoiThuHuong, flowControl)
		setTextIfPresent(this.txtDiaChiNguoiThuHuong(), fields.diaChiNguoiThuHuong, flowControl)
		setTextIfPresent(this.txtNgayHetHan(), fields.ngayHetHan, flowControl)
		// TODO: other fields of section S05 (FO_flows.md, TC 247–321)
	}

	// S06 – Giá trị LC, dung sai, nơi có giá trị
	void fillGiaTriLc(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		selectOption(this.ddlLoaiTien(), fields.loaiTien, flowControl)
		setTextIfPresent(this.txtSoTien(), fields.soTien, flowControl)
		// TODO: other fields of section S06 (FO_flows.md, TC 322–331)
	}

	// S07 – Phương thức thanh toán, hối phiếu, kỳ hạn
	void fillThanhToan(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S07 (FO_flows.md, TC 332–351)
	}

	// S08 – Giao hàng & hàng hoá
	void fillGiaoHang(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S08 (FO_flows.md, TC 352–387)
	}

	// S09 – Điều khoản bổ sung
	void fillDieuKhoanBoSung(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S09 (FO_flows.md, TC 388–403)
	}

	// S10 – Phí & thời hạn xuất trình chứng từ
	void fillPhi(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S10 (FO_flows.md, TC 404–441)
	}

	// S11 – Thông tin khác, nguồn tiền, lãi suất, phương thức trả nợ
	void fillThongTinKhac(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S11 (FO_flows.md, TC 442–502)
	}

	// S12 – Chứng từ yêu cầu (Documents required)
	void fillChungTuYeuCau(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S12 (FO_flows.md, TC 689–707)
	}

	// S13 – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting
	void fillAdditionalConditions(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S13 (FO_flows.md, TC 708–745)
	}

	// S14 – Cam kết bổ sung chứng từ
	void fillCamKet(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		// TODO: fields of section S14 (FO_flows.md, TC 746–759, 771–775)
	}

	// S15 – Điều khoản & điều kiện, Hồ sơ đính kèm (upload: SharedBusinessKeywords.uploadDocument)
	void fillDieuKhoan(Map<String, String> fields, FailureHandling flowControl = defaultFailureHandling) {
		setTextIfPresent(this.txtHuongDan(), fields.huongDan, flowControl)
		// TODO: other fields of section S15 (FO_flows.md, TC 503–532)
	}

	String getRequestCode() {
		if (!waitForElementPresent(this.lblRequestCode(), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)) {
			return null
		}
		return getText(this.lblRequestCode(), FailureHandling.OPTIONAL)?.trim()
	}

	private void setTextIfPresent(TestObject field, String value, FailureHandling flowControl) {
		if (value != null) {
			setText(field, value, flowControl)
		}
	}

	private void selectOption(TestObject dropdown, String option, FailureHandling flowControl) {
		if (option != null) {
			WebUIKeyword.click(dropdown, flowControl)
			WebUIKeyword.click(this.ddlOption(option), flowControl)
		}
	}
}
