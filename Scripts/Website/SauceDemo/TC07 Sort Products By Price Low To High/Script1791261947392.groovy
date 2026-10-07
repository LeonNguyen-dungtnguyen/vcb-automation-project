import com.vcb.assertions.BaseAssert
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.WebSauceDemoPage
import com.vcb.utils.ListUtils

WebSauceDemoPage webSauceDemoPage = WebBasePage.getPage(WebSauceDemoPage)

try {
	webSauceDemoPage.loginAsStandardUser()
	List<String> expectedOptions = ListUtils.parseObjectMessageToList(sortOptions)
	BaseAssert.equals(expectedOptions, webSauceDemoPage.getSortOptions(), 'Sort dropdown options')

	webSauceDemoPage.sortProductsBy(sortValue)
	List<Long> prices = webSauceDemoPage.getItemPricesInCents()
	BaseAssert.equals(prices.sort(false), prices, 'Products are ordered by price low to high')
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
