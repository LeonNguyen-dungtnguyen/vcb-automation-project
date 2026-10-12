package com.vcb.m2u.internal.pages.base.lc.bo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * "Phân công lại" popup.
 */
public class WebBoReassignPopup extends WebBasePage {

	public static TestObject ddlAssignee() {
		return findTestObject('Object Repository/LC_ISS/BO/ReassignPopup/ddlAssignee')
	}

	public static TestObject ddlAssigneeOption(String user) {
		return findTestObject('Object Repository/LC_ISS/BO/ReassignPopup/ddlAssigneeOption', [user: user])
	}

	public static TestObject btnConfirm() {
		return findTestObject('Object Repository/LC_ISS/BO/ReassignPopup/btnConfirm')
	}

	void reassignTo(String user, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.ddlAssignee(), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.ddlAssignee(), flowControl)
		WebUIKeyword.click(this.ddlAssigneeOption(user), flowControl)
		WebUIKeyword.click(this.btnConfirm(), flowControl)
	}
}
