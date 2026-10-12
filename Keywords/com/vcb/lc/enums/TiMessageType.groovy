package com.vcb.lc.enums

/**
 * MT700 issuance message returned by TI: electronically signed or not.
 */
public enum TiMessageType {
	SIGNED('Bản điện tử có ký số'),
	UNSIGNED('Bản không ký số')

	final String label

	TiMessageType(String label) {
		this.label = label
	}
}
