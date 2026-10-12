package com.vcb.m2u.internal.pages.base.lc.fo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * FO login screen.
 */
public class WebFoLoginPage extends WebBasePage {

	public static TestObject txtUsername() {
		return findTestObject('Object Repository/LC_ISS/FO/Login/txtUsername')
	}

	public static TestObject txtPassword() {
		return findTestObject('Object Repository/LC_ISS/FO/Login/txtPassword')
	}

	public static TestObject btnLogin() {
		return findTestObject('Object Repository/LC_ISS/FO/Login/btnLogin')
	}

	public static TestObject lblHomeTitle() {
		return findTestObject('Object Repository/LC_ISS/FO/Login/lblHomeTitle')
	}

	void open(String url, FailureHandling flowControl = defaultFailureHandling) {
		WebUI.navigateToUrl(url)
		waitForElementVisible(this.txtUsername(), GlobalVariable.G_timeoutMedium, flowControl)
	}

	/**
	 * @param encryptedPassword password stored as Katalon encrypted text in the profile
	 */
	void login(String username, String encryptedPassword, FailureHandling flowControl = defaultFailureHandling) {
		setText(this.txtUsername(), username, flowControl)
		setEncryptedText(this.txtPassword(), encryptedPassword, flowControl)
		WebUIKeyword.click(this.btnLogin(), flowControl)
		waitForElementVisible(this.lblHomeTitle(), GlobalVariable.G_timeoutMedium, flowControl)
	}
}
