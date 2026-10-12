package com.vcb.lc.enums

/**
 * Trả lại (send back for editing) or Từ chối (reject).
 */
public enum ReturnRejectAction {
	RETURN('Trả lại'),
	REJECT('Từ chối')

	final String label

	ReturnRejectAction(String label) {
		this.label = label
	}
}
