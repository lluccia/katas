package checkout;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PriceListTest {
    
    private PriceList priceList;
    
    @Before
    public void setup() {
        priceList = PriceList.createDefaultPriceList();
    }
    
    @Test 
    public void canCreateDefaultPriceList() {
        assertThat(product("A").getUnitPrice(), is(closeTo(50.0, 0.00001)));
        assertThat(product("A").getSpecialPriceQuantity(), is(3));
        assertThat(product("A").getSpecialPrice(), is(closeTo(130.0, 0.00001)));
        
        assertThat(product("B").getUnitPrice(), is(closeTo(30.0, 0.00001)));
        assertThat(product("B").getSpecialPriceQuantity(), is(2));
        assertThat(product("B").getSpecialPrice(), is(closeTo(45.0, 0.00001)));
        
        assertThat(product("C").getUnitPrice(), is(closeTo(20.0, 0.00001)));
    
        assertThat(product("D").getUnitPrice(), is(closeTo(15.0, 0.00001)));
    }

    private Product product(String productId) {
        return priceList.find(productId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findNonExistentProductOnPriceList_shouldThrowException() {
        PriceList pricelist = new PriceList();
        Product productA = new Product("A");
        pricelist.add(productA);

        pricelist.find("B");
    }
    
    @Test
    public void pricePerQuantityWithNoSpecialPrice_shouldReturnSumOfUnitPrices() {
        assertThat(priceList.getProductsPrice(product("C"), 3), is(closeTo(60, 0.00001)));
    }
    
    @Test
    public void pricePerSpecialPriceQuantity_shouldReturnSpecialPrice() {
        assertThat(priceList.getProductsPrice(product("A"), 3), is(closeTo(130, 0.00001)));
        assertThat(priceList.getProductsPrice(product("B"), 2), is(closeTo(45, 0.00001)));
    }
    
    @Test
    public void pricePerLessThanSpecialPriceQuantity_shouldReturnSumOfUnitPrices() {
        assertThat(priceList.getProductsPrice(product("A"), 2), is(closeTo(100, 0.00001)));
        assertThat(priceList.getProductsPrice(product("B"), 1), is(closeTo(30, 0.00001)));
    }
    
    @Test
    public void pricePerMultipleOfSpecialPriceQuantity_shouldReturnSpecialPricePackQuantity() {
        assertThat(priceList.getProductsPrice(product("A"), 6), is(closeTo(260, 0.00001)));
        assertThat(priceList.getProductsPrice(product("B"), 4), is(closeTo(90, 0.00001)));
    }
    
    @Test
    public void pricePerNonMultipleOfSpecialPriceQuantity_shouldReturnSpecialPricePackQuantityPlusSumOfUnitPrices() {
        assertThat(priceList.getProductsPrice(product("A"), 5), is(closeTo(230, 0.00001)));
        assertThat(priceList.getProductsPrice(product("B"), 3), is(closeTo(75, 0.00001)));
    }
}

