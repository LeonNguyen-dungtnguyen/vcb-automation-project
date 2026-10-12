package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

import internal.GlobalVariable

/**
 * File buttons of a transaction (TBTN, file tác nghiệp, YCXL, hồ sơ KH) and the file viewer.
 */
public class WebFileViewer extends WebBasePage {

	public static TestObject btnViewFile(String fileType) {
		return findTestObject('Object Repository/LC_ISS/Common/FileViewer/btnViewFile', [fileType: fileType])
	}

	public static TestObject optFormat(String format) {
		return findTestObject('Object Repository/LC_ISS/Common/FileViewer/optFormat', [format: format])
	}

	public static TestObject btnDownload() {
		return findTestObject('Object Repository/LC_ISS/Common/FileViewer/btnDownload')
	}

	public static TestObject lblViewerTitle() {
		return findTestObject('Object Repository/LC_ISS/Common/FileViewer/lblViewerTitle')
	}

	void openFile(String fileType, FailureHandling flowControl = defaultFailureHandling) {
		waitForElementClickable(this.btnViewFile(fileType), GlobalVariable.G_timeoutMedium, flowControl)
		WebUIKeyword.click(this.btnViewFile(fileType), flowControl)
	}

	/** Choose .doc / .pdf when the screen asks for a format. */
	void chooseFormatIfAsked(String format, FailureHandling flowControl = defaultFailureHandling) {
		if (waitForElementPresent(this.optFormat(format), GlobalVariable.G_timeoutShort, FailureHandling.OPTIONAL)) {
			WebUIKeyword.click(this.optFormat(format), flowControl)
		}
	}
}
