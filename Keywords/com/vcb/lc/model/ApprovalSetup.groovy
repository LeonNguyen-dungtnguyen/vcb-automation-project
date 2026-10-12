package com.vcb.lc.model

/**
 * FO approval configuration of the customer: number of approval levels × Ký số pháp nhân (PN) required.
 * It is a property of the test users' configuration on SIT; the keywords use it to know the expected statuses.
 */
public class ApprovalSetup {
	static final ApprovalSetup ONE_LEVEL_NO_PN = new ApprovalSetup(1, false)   // TC1
	static final ApprovalSetup ONE_LEVEL_WITH_PN = new ApprovalSetup(1, true)  // TC2
	static final ApprovalSetup TWO_LEVEL_NO_PN = new ApprovalSetup(2, false)   // TC3
	static final ApprovalSetup TWO_LEVEL_WITH_PN = new ApprovalSetup(2, true)  // TC4

	final int levels
	final boolean companySignature

	ApprovalSetup(int levels, boolean companySignature) {
		if (levels != 1 && levels != 2) {
			throw new IllegalArgumentException("Approval levels must be 1 or 2, got ${levels}")
		}
		this.levels = levels
		this.companySignature = companySignature
	}

	@Override
	String toString() {
		return "${levels} cấp duyệt, ${companySignature ? 'có' : 'không'} ký số pháp nhân"
	}
}
