package checkout;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

	private Checkout checkout;
	private PriceList priceList;
	
	@Before
	public void setUp() {
		priceList = PriceList.createDefaultPriceList();
		checkout = new Checkout(priceList);
	}

	@Test
	public void newCheckout_totalIsZero() {
		assertThat(checkout.total(), is(closeTo(0, 0.00001)));
	}

	@Test
	public void afterScanOneProduct_totalIsUnitPrice() {
		checkout.scan("A");

		assertThat(checkout.total(), is(closeTo(50, 0.00001)));
	}
	
	@Test
	public void afterScanTwoProducts_totalIsSumOfUnitPrices() {
		checkout.scan("A");
		checkout.scan("B");

		assertThat(checkout.total(), is(closeTo(80, 0.00001)));
	}
	
	@Test
	public void afterScanProductsWithSpecialPrice_totalIsSpecialPrice() {
		checkout.scan("A");
		checkout.scan("A");
		checkout.scan("A");

		assertThat(checkout.total(), is(closeTo(130, 0.00001)));
	}
	
	@Test
	public void canGetQuantityOfItemsPerProduct() {
		checkout.scan("A");
		checkout.scan("B");
		checkout.scan("A");
		checkout.scan("C");
		checkout.scan("B");
		checkout.scan("B");
		
		Map<Product, Integer> quantityPerProduct = checkout.getQuantityPerProduct();
		Set<Product> products = quantityPerProduct.keySet();
		
		Product productA = priceList.find("A");
		Product productB = priceList.find("B");
		Product productC = priceList.find("C");
		
		assertThat(products.size(), is(3));
		assertThat(quantityPerProduct, hasEntry(productA, 2));
		assertThat(quantityPerProduct, hasEntry(productB, 3));
		assertThat(quantityPerProduct, hasEntry(productC, 1));
	}

}
