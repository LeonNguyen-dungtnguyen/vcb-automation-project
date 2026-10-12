package com.vcb.lc.enums

/**
 * Đề xuất chosen by CA/CRC when entering processing info: (1) phê duyệt, (2) từ chối.
 */
public enum BoProposal {
	APPROVE('(1)'),
	REJECT('(2)')

	final String label

	BoProposal(String label) {
		this.label = label
	}
}
