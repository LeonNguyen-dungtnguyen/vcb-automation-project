package com.vcb.lc.enums

/**
 * Files that can be viewed/downloaded from a transaction (button text on screen).
 */
public enum BoFileType {
	TBTN('File TBTN'),
	FILE_TAC_NGHIEP('Xem file tác nghiệp'),
	YCXL('File YCXL giao dịch'),
	HO_SO_KH('Tải hồ sơ khách hàng')

	final String label

	BoFileType(String label) {
		this.label = label
	}
}
