package com.vcb.lc.enums

/**
 * Lưu or Gửi duyệt on the BO processing screen.
 */
public enum BoSaveAction {
	SAVE('Lưu'),
	SUBMIT('Gửi duyệt')

	final String label

	BoSaveAction(String label) {
		this.label = label
	}
}
