import com.vcb.assertions.BaseAssert
import com.vcb.assertions.StringAssert
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.WebSauceDemoPage
import com.vcb.utils.DateUtils
import com.vcb.utils.StringUtils

WebSauceDemoPage webSauceDemoPage = WebBasePage.getPage(WebSauceDemoPage)

try {
	webSauceDemoPage.loginAsStandardUser()
	String footerText = webSauceDemoPage.getFooterText()
	StringAssert.contains(footerText, copyrightText, true, 'Footer shows the copyright text')

	String footerYear = StringUtils.extractStrPattern(footerText, '\\d{4}')
	String currentYear = DateUtils.getCurrentDate(timeZone, 'yyyy')
	BaseAssert.equals(currentYear, footerYear, 'Footer copyright year is the current year')
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
