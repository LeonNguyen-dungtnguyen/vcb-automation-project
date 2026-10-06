import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.vcb.common.WebUIKeyword

import internal.GlobalVariable

class TestListener {

	private static final String WEBSITE_TEST_CASE_FOLDER = 'Test Cases/Website/'

	/**
	 * Open the browser at G_url before every website test case.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		if (!testCaseContext.getTestCaseId().startsWith(WEBSITE_TEST_CASE_FOLDER)) {
			return
		}
		WebUIKeyword.openBrowser(GlobalVariable.G_url)
	}

	/**
	 * Capture the final state and close the browser after every website test case.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		if (!testCaseContext.getTestCaseId().startsWith(WEBSITE_TEST_CASE_FOLDER)) {
			return
		}
		WebUIKeyword.takeScreenshot()
		WebUIKeyword.closeBrowser()
	}
}
