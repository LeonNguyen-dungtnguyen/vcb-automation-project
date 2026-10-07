import com.vcb.assertions.BaseAssert
import com.vcb.assertions.NumberAssert
import com.vcb.common.WebUIKeyword
import com.vcb.m2u.internal.pages.base.WebBasePage
import com.vcb.m2u.internal.pages.base.WebSauceDemoPage
import com.vcb.utils.MapUtils
import com.vcb.utils.StringUtils

WebSauceDemoPage webSauceDemoPage = WebBasePage.getPage(WebSauceDemoPage)

try {
	Map customer = MapUtils.parseJsonToMap(customerInfo)

	webSauceDemoPage.loginAsStandardUser()
	webSauceDemoPage.addBackpackToCart()
	webSauceDemoPage.addBikeLightToCart()
	webSauceDemoPage.goToCart()
	webSauceDemoPage.goToCheckoutOverview(customer.firstName, customer.lastName, customer.postalCode)

	List<Long> itemPrices = webSauceDemoPage.getItemPricesInCents()
	long subtotal = webSauceDemoPage.getSummaryAmountInCents(WebSauceDemoPage.lblSubtotal())
	long tax = webSauceDemoPage.getSummaryAmountInCents(WebSauceDemoPage.lblTax())
	long total = webSauceDemoPage.getSummaryAmountInCents(WebSauceDemoPage.lblTotal())

	BaseAssert.equals(expectedItemCount as int, itemPrices.size(), 'Number of items on checkout overview')
	BaseAssert.equals(itemPrices.sum() as long, subtotal, "Item total ${StringUtils.formatToMoney(subtotal.toString())} equals the sum of item prices")
	NumberAssert.isGreaterThan(tax, 0, "Tax ${StringUtils.formatToMoney(tax.toString())} is charged")
	BaseAssert.equals(subtotal + tax, total, "Total ${StringUtils.formatToMoney(total.toString())} equals item total plus tax")
} catch (Exception ex) {
	WebUIKeyword.takeScreenshot()
	throw ex
}
