import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.vcb.common.WebUIKeyword

import internal.GlobalVariable

class TestListener {

	private static final String WEBSITE_TEST_CASE_FOLDER = 'Test Cases/Website/'
	private static final String LC_TEST_CASE_FOLDER = 'Test Cases/LC_ISS/'

	/**
	 * Open the browser at G_url before every website test case.
	 * LC_ISS test cases get an empty browser: the login keywords navigate to G_foUrl / G_boUrl.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		if (testCaseId.startsWith(LC_TEST_CASE_FOLDER)) {
			WebUIKeyword.openBrowser('')
			return
		}
		if (!testCaseId.startsWith(WEBSITE_TEST_CASE_FOLDER)) {
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
		String testCaseId = testCaseContext.getTestCaseId()
		if (!testCaseId.startsWith(WEBSITE_TEST_CASE_FOLDER) && !testCaseId.startsWith(LC_TEST_CASE_FOLDER)) {
			return
		}
		WebUIKeyword.takeScreenshot()
		WebUIKeyword.closeBrowser()
	}
}
