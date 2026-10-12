package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * Confirmation popup with Có / Không (Hủy đề nghị, Xóa đề nghị, ...). Shared by FO and BO.
 */
public class WebConfirmPopup extends WebBasePage {

	public static TestObject lblMessage() {
		return findTestObject('Object Repository/LC_ISS/Common/ConfirmPopup/lblMessage')
	}

	public static TestObject btnYes() {
		return findTestObject('Object Repository/LC_ISS/Common/ConfirmPopup/btnYes')
	}

	public static TestObject btnNo() {
		return findTestObject('Object Repository/LC_ISS/Common/ConfirmPopup/btnNo')
	}

	void confirm(FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.btnYes(), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.btnYes(), flowControl)
	}

	void cancel(FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.btnNo(), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.btnNo(), flowControl)
	}
}
