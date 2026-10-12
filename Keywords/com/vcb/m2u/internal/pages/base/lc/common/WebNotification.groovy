package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * Success / error toast shown after an action. Shared by FO and BO.
 */
public class WebNotification extends WebBasePage {

	public static TestObject lblSuccessMessage() {
		return findTestObject('Object Repository/LC_ISS/Common/Notification/lblSuccessMessage')
	}

	public static TestObject lblErrorMessage() {
		return findTestObject('Object Repository/LC_ISS/Common/Notification/lblErrorMessage')
	}

	String waitForSuccess(FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.lblSuccessMessage(), GlobalVariable.G_timeoutMedium, flowControl)
		return getText(this.lblSuccessMessage(), flowControl)
	}
}
