package com.vcb.m2u.internal.pages.base.lc.fo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * FO request detail screen with the action buttons of every role.
 */
public class WebFoLcDetailPage extends WebBasePage {

	public static TestObject lblStatus() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/lblStatus')
	}

	public static TestObject lblRequestCode() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/lblRequestCode')
	}

	public static TestObject btnApprove() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnApprove')
	}

	public static TestObject btnSign() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnSign')
	}

	public static TestObject btnReturn() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnReturn')
	}

	public static TestObject btnReject() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnReject')
	}

	public static TestObject btnCancelRequest() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnCancelRequest')
	}

	public static TestObject btnDeleteRequest() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnDeleteRequest')
	}

	public static TestObject btnEdit() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnEdit')
	}

	public static TestObject btnSubmit() {
		return findTestObject('Object Repository/LC_ISS/FO/LcDetail/btnSubmit')
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
