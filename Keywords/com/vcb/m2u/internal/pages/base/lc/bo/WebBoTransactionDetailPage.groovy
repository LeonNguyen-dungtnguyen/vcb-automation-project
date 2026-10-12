package com.vcb.m2u.internal.pages.base.lc.bo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * BO transaction processing screen with the action buttons of every BO role.
 */
public class WebBoTransactionDetailPage extends WebBasePage {

	public static TestObject lblStatus() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/lblStatus')
	}

	public static TestObject btnReceive() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnReceive')
	}

	public static TestObject btnSave() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnSave')
	}

	public static TestObject btnSubmit() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnSubmit')
	}

	public static TestObject btnApprove() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnApprove')
	}

	public static TestObject btnReturn() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnReturn')
	}

	public static TestObject btnReject() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnReject')
	}

	public static TestObject btnReassign() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnReassign')
	}

	public static TestObject btnSign() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/btnSign')
	}

	public static TestObject chkSendToBgdCn() {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionDetail/chkSendToBgdCn')
	}

	void clickAction(TestObject button, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementClickable(button, GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(button, flowControl)
	}

	String getStatus(FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.lblStatus(), GlobalVariable.G_timeoutMedium, flowControl)
		return getText(this.lblStatus(), flowControl).trim()
	}

	void verifyStatus(String expected, FailureHandling flowControl = defaultFailureHandling) {
		WebUI.verifyMatch(getStatus(flowControl), expected, false, flowControl)
	}
}
