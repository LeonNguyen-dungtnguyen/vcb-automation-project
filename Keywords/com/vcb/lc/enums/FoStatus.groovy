package com.vcb.lc.enums

import com.vcb.lc.model.ApprovalSetup

/**
 * FO request statuses (label = text shown on screen) and the expected-status rules of the FO flow.
 * Source: requirements/LC_ISS/FO/FO_flows.md §1.
 */
public enum FoStatus {
	BAN_NHAP('Bản nháp'),
	CHO_DUYET('Chờ duyệt'),
	CHO_DUYET_CAP_TIEP_THEO('Chờ duyệt cấp tiếp theo'),
	CHO_KY_SO_PHAP_NHAN('Chờ ký số pháp nhân'),
	DA_GUI_NGAN_HANG('Đã gửi ngân hàng'),
	YEU_CAU_CHINH_SUA('Yêu cầu chỉnh sửa'),
	TU_CHOI('Từ chối'),
	DA_HUY('Đã hủy')

	final String label

	FoStatus(String label) {
		this.label = label
	}

	/**
	 * Status after Phê duyệt + 2FA.
	 * Kế toán phó in a 2-level setup → Chờ duyệt cấp tiếp theo; the final approver → Chờ duyệt.
	 */
	static FoStatus afterApproval(FoRole approver, ApprovalSetup setup) {
		if (setup.levels == 2 && approver == FoRole.KE_TOAN_PHO) {
			return CHO_DUYET_CAP_TIEP_THEO
		}
		// TO CONFIRM on SIT: "Chờ duyệt" (FO_flows.md, LC_PHAT_HANH spec step 9) or "Chờ ký số" (some TCs)
		return CHO_DUYET
	}

	/**
	 * Status after Ký số cá nhân by Chủ tài khoản.
	 */
	static FoStatus afterPersonalSignature(ApprovalSetup setup) {
		return setup.companySignature ? CHO_KY_SO_PHAP_NHAN : DA_GUI_NGAN_HANG
	}

	/**
	 * Status after Trả lại / Từ chối.
	 * Trả lại → Yêu cầu chỉnh sửa; Kế toán trưởng từ chối → Đã hủy; Chủ tài khoản từ chối → Từ chối.
	 */
	static FoStatus afterReturnOrReject(FoRole role, ReturnRejectAction action) {
		if (action == ReturnRejectAction.RETURN) {
			return YEU_CAU_CHINH_SUA
		}
		return role == FoRole.CHU_TAI_KHOAN ? TU_CHOI : DA_HUY
	}
}
