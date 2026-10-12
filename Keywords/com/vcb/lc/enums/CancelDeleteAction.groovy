package com.vcb.lc.enums

/**
 * Hủy đề nghị or Xóa đề nghị on an FO request.
 */
public enum CancelDeleteAction {
	CANCEL('Hủy đề nghị'),
	DELETE('Xóa đề nghị')

	final String label

	CancelDeleteAction(String label) {
		this.label = label
	}
}
