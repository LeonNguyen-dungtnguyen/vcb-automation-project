package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * Popup asking for a reason / ý kiến (Trả lại, Từ chối). Shared by FO and BO.
 */
public class WebReasonPopup extends WebBasePage {

	public static TestObject txtReason() {
		return findTestObject('Object Repository/LC_ISS/Common/ReasonPopup/txtReason')
	}

	public static TestObject btnConfirm() {
		return findTestObject('Object Repository/LC_ISS/Common/ReasonPopup/btnConfirm')
	}

	public static TestObject btnCancel() {
		return findTestObject('Object Repository/LC_ISS/Common/ReasonPopup/btnCancel')
	}

	void enterReasonAndConfirm(String reason, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.txtReason(), GlobalVariable.G_timeoutMedium, flowControl)
		setText(this.txtReason(), reason, flowControl)
		WebUIKeyword.click(this.btnConfirm(), flowControl)
	}

	void cancel(FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.click(this.btnCancel(), flowControl)
	}
}
