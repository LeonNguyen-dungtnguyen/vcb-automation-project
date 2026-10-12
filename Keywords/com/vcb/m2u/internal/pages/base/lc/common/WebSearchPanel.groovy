package com.vcb.m2u.internal.pages.base.lc.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage

/**
 * Quick search box and advanced filter (bộ lọc) of FO / BO list screens.
 */
public class WebSearchPanel extends WebBasePage {

	public static TestObject txtQuickSearch() {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/txtQuickSearch')
	}

	public static TestObject btnAdvancedFilter() {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/btnAdvancedFilter')
	}

	public static TestObject txtFilterField(String fieldName) {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/txtFilterField', [fieldName: fieldName])
	}

	public static TestObject btnSearch() {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/btnSearch')
	}

	public static TestObject btnApply() {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/btnApply')
	}

	public static TestObject btnReset() {
		return findTestObject('Object Repository/LC_ISS/Common/SearchPanel/btnReset')
	}

	void quickSearch(String keyword, FailureHandling flowControl = defaultFailureHandling) {
		setText(this.txtQuickSearch(), keyword, flowControl)
		WebUIKeyword.click(this.btnSearch(), flowControl)
	}

	/**
	 * @param criteria filter field label → value. TO CONFIRM on SIT: Tìm kiếm vs Áp dụng button per screen.
	 */
	void filter(Map<String, String> criteria, FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.click(this.btnAdvancedFilter(), flowControl)
		criteria.each { String fieldName, String value ->
			setText(this.txtFilterField(fieldName), value, flowControl)
		}
		WebUIKeyword.click(this.btnSearch(), flowControl)
	}
}
