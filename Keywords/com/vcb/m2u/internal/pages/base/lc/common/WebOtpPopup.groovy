package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

/**
 * Popup "Xác thực" (2FA / OTP) shown on Phê duyệt, Từ chối, Xóa in FO.
 * The OTP value itself is entered by SecurityStepHandler.enterOtp.
 */
public class WebOtpPopup extends WebBasePage {

	public static TestObject txtOtp() {
		return findTestObject('Object Repository/LC_ISS/Common/OtpPopup/txtOtp')
	}

	public static TestObject btnConfirm() {
		return findTestObject('Object Repository/LC_ISS/Common/OtpPopup/btnConfirm')
	}

	public static TestObject lblError() {
		return findTestObject('Object Repository/LC_ISS/Common/OtpPopup/lblError')
	}

	void confirm(FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.click(this.btnConfirm(), flowControl)
	}
}
