package com.vcb.lc.enums

/**
 * BO (bank) roles of LC Issuance.
 * Each role maps to a username/password pair in the SIT_LC profile.
 */
public enum BoRole {
	CA('CA', 'G_boCaUser', 'G_boCaPassword'),
	CA_LEAD('CA lead', 'G_boCaLeadUser', 'G_boCaLeadPassword'),
	CRC('CRC', 'G_boCrcUser', 'G_boCrcPassword'),
	CRC_LEAD('CRC lead', 'G_boCrcLeadUser', 'G_boCrcLeadPassword'),
	BGD_CN('BGĐ CN', 'G_boBgdCnUser', 'G_boBgdCnPassword')

	final String label
	final String userVar
	final String passwordVar

	BoRole(String label, String userVar, String passwordVar) {
		this.label = label
		this.userVar = userVar
		this.passwordVar = passwordVar
	}
}
