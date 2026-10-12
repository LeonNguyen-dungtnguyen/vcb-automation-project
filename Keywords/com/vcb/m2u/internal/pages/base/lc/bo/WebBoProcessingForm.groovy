package com.vcb.m2u.internal.pages.base.lc.bo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.WebUIKeyword
import com.vcb.lc.enums.BoProposal
import com.vcb.m2u.internal.pages.base.WebBasePage

/**
 * "Thông tin xử lý" form filled by CA / CRC, with the Đề xuất (1) phê duyệt / (2) từ chối choice.
 */
public class WebBoProcessingForm extends WebBasePage {

	public static TestObject rdoProposal(String proposal) {
		return findTestObject('Object Repository/LC_ISS/BO/ProcessingForm/rdoProposal', [proposal: proposal])
	}

	public static TestObject txtFieldByLabel(String label) {
		return findTestObject('Object Repository/LC_ISS/BO/ProcessingForm/txtFieldByLabel', [label: label])
	}

	void selectProposal(BoProposal proposal, FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.click(this.rdoProposal(proposal.label), flowControl)
	}

	/**
	 * @param labelToValue field label on screen → value. TODO: field list of Thông tin xử lý (BO_happy_cases.md)
	 */
	void fillInfo(Map<String, String> labelToValue, FailureHandling flowControl = defaultFailureHandling) {
		labelToValue.each { String label, String value ->
			setText(this.txtFieldByLabel(label), value, flowControl)
		}
	}
}
