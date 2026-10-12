package com.vcb.m2u.internal.pages.base.lc.fo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * FO list of LC issuance requests (Danh sách đề nghị phát hành LC).
 */
public class WebFoLcListPage extends WebBasePage {

	public static TestObject btnCreateNew() {
		return findTestObject('Object Repository/LC_ISS/FO/LcList/btnCreateNew')
	}

	public static TestObject tabByName(String tabName) {
		return findTestObject('Object Repository/LC_ISS/FO/LcList/tabByName', [tabName: tabName])
	}

	public static TestObject lnkRequestCode(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/FO/LcList/lnkRequestCode', [requestCode: requestCode])
	}

	public static TestObject lblRowStatus(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/FO/LcList/lblRowStatus', [requestCode: requestCode])
	}

	void openCreateNew(FailureHandling flowControl = defaultFailureHandling) {
		waitForElementClickable(this.btnCreateNew(), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.btnCreateNew(), flowControl)
	}

	void openRequest(String requestCode, String tab = null, FailureHandling flowControl = defaultFailureHandling) {
		if (tab) {
			WebUIKeyword.click(this.tabByName(tab), flowControl)
		}
		waitForElementVisible(this.lnkRequestCode(requestCode), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.lnkRequestCode(requestCode), flowControl)
	}

	boolean isRequestListed(String requestCode) {
		return waitForElementPresent(this.lnkRequestCode(requestCode), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)
	}

	String getRowStatus(String requestCode, FailureHandling flowControl = defaultFailureHandling) {
		return getText(this.lblRowStatus(requestCode), flowControl)
	}
}
