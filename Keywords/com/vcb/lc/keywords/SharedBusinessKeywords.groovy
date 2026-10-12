package com.vcb.lc.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.BoFileType
import com.vcb.lc.enums.FileFormat
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.lc.common.WebAddDocumentPopup
import com.vcb.m2u.internal.pages.base.lc.common.WebFileViewer
import com.vcb.m2u.internal.pages.base.lc.common.WebSearchPanel

import internal.GlobalVariable

/**
 * Business keywords shared by FO and BO – composite steps of requirements/LC_ISS/COMPOSITE_STEPS.md:
 *  #22 uploadDocument     – Upload tài liệu (popup Thêm tài liệu)
 *  #23 search             – Tìm kiếm / bộ lọc
 *  #24 viewOrDownloadFile – Xem / tải file (TBTN, tác nghiệp, YCXL, hồ sơ KH)
 */
public class SharedBusinessKeywords extends WebUIKeyword {

	static final String QUICK_SEARCH = 'quick'

	/**
	 * #22 Upload a file in the Thêm tài liệu popup and check it is listed.
	 */
	@Keyword
	static void uploadDocument(String filePath, FailureHandling flowControl = defaultFailureHandling) {
		WebAddDocumentPopup popup = WebBasePage.getPage(WebAddDocumentPopup)
		popup.openIfClosed(flowControl)
		popup.upload(filePath, flowControl)
		String fileName = new File(filePath).name
		waitForElementVisible(popup.lblUploadedFile(fileName), GlobalVariable.G_timeoutMedium, flowControl)
	}

	/**
	 * #23 Search a list: [quick: 'text'] uses the quick search box, any other map fills the advanced filter
	 * (filter field label → value).
	 */
	@Keyword
	static void search(Map<String, String> criteria, FailureHandling flowControl = defaultFailureHandling) {
		WebSearchPanel panel = WebBasePage.getPage(WebSearchPanel)
		if (criteria.size() == 1 && criteria.containsKey(QUICK_SEARCH)) {
			panel.quickSearch(criteria[QUICK_SEARCH], flowControl)
		} else {
			panel.filter(criteria, flowControl)
		}
	}

	/**
	 * #24 Open a transaction file. Viewable files must show the viewer;
	 * Tải hồ sơ khách hàng only triggers a download (not verifiable in the browser).
	 */
	@Keyword
	static void viewOrDownloadFile(BoFileType type, FileFormat format = FileFormat.PDF, FailureHandling flowControl = defaultFailureHandling) {
		WebFileViewer viewer = WebBasePage.getPage(WebFileViewer)
		viewer.openFile(type.label, flowControl)
		viewer.chooseFormatIfAsked(format.label, flowControl)
		if (type != BoFileType.HO_SO_KH) {
			waitForElementVisible(viewer.lblViewerTitle(), GlobalVariable.G_timeoutMedium, flowControl)
		}
	}
}
