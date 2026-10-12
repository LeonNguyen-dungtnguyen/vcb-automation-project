package com.vcb.lc.enums

/**
 * BO transaction statuses (label = text shown on screen) and the expected-status rules of the BO flow.
 * Source: requirements/LC_ISS/BO/BO_happy_cases.md, requirements/LC_ISS/COMPOSITE_STEPS.md.
 */
public enum BoStatus {
	CHO_TIEP_NHAN('Chờ tiếp nhận'),
	CBTD_XU_LY('CBTĐ xử lý'),
	QLTD_PHE_DUYET('QLTĐ phê duyệt'),
	CB_QLN_XU_LY('CB QLN xử lý'),
	LD_QLN_PHE_DUYET('LĐ QLN phê duyệt'), // TO CONFIRM on SIT
	BGD_CN_PHE_DUYET('BGĐ CN phê duyệt'), // TO CONFIRM on SIT
	CHO_TI('Chờ TI'), // TO CONFIRM on SIT
	HOAN_THANH('Hoàn thành'),
	HOAN_THANH_CHO_BO_SUNG('Hoàn thành - Chờ bổ sung hồ sơ')

	final String label

	BoStatus(String label) {
		this.label = label
	}

	/**
	 * Status after CA / CRC presses Gửi duyệt.
	 */
	static BoStatus afterSubmit(BoRole role) {
		switch (role) {
			case BoRole.CA:
				return QLTD_PHE_DUYET
			case BoRole.CRC:
				return LD_QLN_PHE_DUYET
			default:
				throw new IllegalArgumentException("Only CA or CRC submit for approval, got ${role}")
		}
	}

	/**
	 * Status a leader opens the transaction in before approving.
	 */
	static BoStatus awaitingApprovalBy(BoRole leader) {
		switch (leader) {
			case BoRole.CA_LEAD:
				return QLTD_PHE_DUYET
			case BoRole.CRC_LEAD:
				return LD_QLN_PHE_DUYET
			case BoRole.BGD_CN:
				return BGD_CN_PHE_DUYET
			default:
				throw new IllegalArgumentException("${leader} is not a leader role")
		}
	}

	/**
	 * Status after a leader presses Phê duyệt.
	 * CA lead → CB QLN xử lý; CRC lead → BGĐ CN phê duyệt (needs BGĐ CN authority) or Chờ TI; BGĐ CN → Chờ TI.
	 */
	static BoStatus afterLeaderApproval(BoRole leader, boolean needsBgdCnAuthority) {
		switch (leader) {
			case BoRole.CA_LEAD:
				return CB_QLN_XU_LY
			case BoRole.CRC_LEAD:
				return needsBgdCnAuthority ? BGD_CN_PHE_DUYET : CHO_TI
			case BoRole.BGD_CN:
				return CHO_TI
			default:
				throw new IllegalArgumentException("${leader} is not a leader role")
		}
	}
}
