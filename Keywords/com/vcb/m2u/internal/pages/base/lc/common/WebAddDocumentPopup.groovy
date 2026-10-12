package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * Popup "Thêm tài liệu" (upload). Shared by FO and BO.
 */
public class WebAddDocumentPopup extends WebBasePage {

	public static TestObject btnOpen() {
		return findTestObject('Object Repository/LC_ISS/Common/AddDocumentPopup/btnOpen')
	}

	public static TestObject inputFile() {
		return findTestObject('Object Repository/LC_ISS/Common/AddDocumentPopup/inputFile')
	}

	public static TestObject btnUpload() {
		return findTestObject('Object Repository/LC_ISS/Common/AddDocumentPopup/btnUpload')
	}

	public static TestObject lblUploadedFile(String fileName) {
		return findTestObject('Object Repository/LC_ISS/Common/AddDocumentPopup/lblUploadedFile', [fileName: fileName])
	}

	public static TestObject btnClose() {
		return findTestObject('Object Repository/LC_ISS/Common/AddDocumentPopup/btnClose')
	}

	/** Open the popup unless it is already open. */
	void openIfClosed(FailureHandling flowControl = defaultFailureHandling) {
		if (!waitForElementPresent(this.inputFile(), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)) {
			WebUIKeyword.click(this.btnOpen(), flowControl)
		}
	}

	void upload(String filePath, FailureHandling flowControl = defaultFailureHandling) {
		WebUI.uploadFile(this.inputFile(), filePath, flowControl)
		WebUIKeyword.click(this.btnUpload(), flowControl)
	}
}
