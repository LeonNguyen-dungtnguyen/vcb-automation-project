package com.vcb.lc.enums

/**
 * FO (customer) roles of LC Issuance.
 * Each role maps to a username/password pair in the SIT_LC profile.
 */
public enum FoRole {
	MAKER('Maker', 'G_foMakerUser', 'G_foMakerPassword'),
	KE_TOAN_PHO('Kế toán phó', 'G_foKeToanPhoUser', 'G_foKeToanPhoPassword'),
	KE_TOAN_TRUONG('Kế toán trưởng', 'G_foKeToanTruongUser', 'G_foKeToanTruongPassword'),
	CHU_TAI_KHOAN('Chủ tài khoản', 'G_foChuTaiKhoanUser', 'G_foChuTaiKhoanPassword'),
	NGUOI_KY_PHAP_NHAN('Người ký pháp nhân', 'G_foNguoiKyPhapNhanUser', 'G_foNguoiKyPhapNhanPassword')

	final String label
	final String userVar
	final String passwordVar

	FoRole(String label, String userVar, String passwordVar) {
		this.label = label
		this.userVar = userVar
		this.passwordVar = passwordVar
	}
}
