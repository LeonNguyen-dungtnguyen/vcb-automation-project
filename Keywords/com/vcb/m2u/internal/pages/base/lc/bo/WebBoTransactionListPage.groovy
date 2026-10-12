package com.vcb.m2u.internal.pages.base.lc.bo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * BO transaction list (tabs Cần xử lý, ...; hyperlink TT opens the transaction).
 */
public class WebBoTransactionListPage extends WebBasePage {

	public static TestObject tabByName(String tabName) {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionList/tabByName', [tabName: tabName])
	}

	public static TestObject lnkRequestCode(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionList/lnkRequestCode', [requestCode: requestCode])
	}

	public static TestObject lnkStatus(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionList/lnkStatus', [requestCode: requestCode])
	}

	public static TestObject lblRowStatus(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionList/lblRowStatus', [requestCode: requestCode])
	}

	public static TestObject btnQueryTransaction(String requestCode) {
		return findTestObject('Object Repository/LC_ISS/BO/TransactionList/btnQueryTransaction', [requestCode: requestCode])
	}

	void openTab(String tabName, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementClickable(this.tabByName(tabName), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.tabByName(tabName), flowControl)
	}

	/**
	 * Open the transaction with the TT hyperlink ("Truy vấn giao dịch / Nhấn hyperlink").
	 */
	void openByRequestCode(String requestCode, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementVisible(this.lnkStatus(requestCode), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.lnkStatus(requestCode), flowControl)
	}

	String getRowStatus(String requestCode, FailureHandling flowControl = defaultFailureHandling) {
		return getText(this.lblRowStatus(requestCode), flowControl)
	}
}
