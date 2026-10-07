import com.vcb.assertions.BaseAssert
import com.vcb.assertions.NumberAssert
import com.vcb.assertions.StringAssert
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.WebSauceDemoPage
import com.vcb.utils.StringUtils

WebSauceDemoPage webSauceDemoPage = WebBasePage.getPage(WebSauceDemoPage)

try {
	webSauceDemoPage.loginAsStandardUser()
	List<String> prices = webSauceDemoPage.getItemPrices()
	BaseAssert.equals(expectedProductCount as int, prices.size(), 'Number of products on inventory page')

	prices.each { String price ->
		StringAssert.startsWith(price, currencySymbol, true, "Price '${price}' starts with the currency symbol")
		BaseAssert.isNotNull(StringUtils.extractStrPattern(price, pricePattern), "Price '${price}' has 2 decimal places")
		NumberAssert.isGreaterThan(StringUtils.parseAmountStringToIntegerInApp(price), 0, "Price '${price}' is positive")
	}
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
