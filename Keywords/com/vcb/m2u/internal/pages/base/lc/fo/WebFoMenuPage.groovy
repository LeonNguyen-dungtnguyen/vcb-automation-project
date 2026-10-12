package com.vcb.m2u.internal.pages.base.lc.fo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * FO main menu and user menu (logout).
 */
public class WebFoMenuPage extends WebBasePage {

	// Menu labels - TO CONFIRM on SIT
	static final String MENU_LC_ISSUANCE = 'Phát hành LC'
	static final String MENU_COMPANY_SIGNATURE = 'Ký số pháp nhân'

	public static TestObject mnuItem(String menuName) {
		return findTestObject('Object Repository/LC_ISS/FO/Menu/mnuItem', [menuName: menuName])
	}

	public static TestObject btnUserMenu() {
		return findTestObject('Object Repository/LC_ISS/FO/Menu/btnUserMenu')
	}

	public static TestObject btnLogout() {
		return findTestObject('Object Repository/LC_ISS/FO/Menu/btnLogout')
	}

	void goTo(String menuName, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementClickable(this.mnuItem(menuName), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.mnuItem(menuName), flowControl)
	}

	boolean isLoggedIn() {
		return waitForElementPresent(this.btnUserMenu(), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)
	}

	void logout(FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.click(this.btnUserMenu(), flowControl)
		WebUIKeyword.click(this.btnLogout(), flowControl)
	}
}
