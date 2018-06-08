package checkout;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {

    @Test
    public void canGetProductUnitPrice() {
        Product productA = new Product("A");
        productA.setUnitPrice(50.0);
        assertThat(productA.getUnitPrice(), is(closeTo(50.0, 0.00001)));
    }
    
    @Test
    public void canGetProductSpecialPrice() {
        Product productA = new Product("A");
        productA.setSpecialPriceQuantity(3);
        productA.setSpecialPrice(130.0);
        
        assertThat(productA.getSpecialPriceQuantity(), is(3));
        assertThat(productA.getSpecialPrice(), is(closeTo(130.0, 0.00001)));
    }
    
    @Test
    public void productWithNoSpecialPrice_specialPriceQuantityIsZero() {
        Product productA = new Product("A");
        
        assertThat(productA.getSpecialPriceQuantity(), is(0));
    }
    
}
