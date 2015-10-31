package checkout;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest {
	
	private PriceList priceList = PriceList.createDefaultPriceList();
	
	private Checkout checkout;
	
	
	@Before
	public void setUp() {
		resetCheckout();
	}

	private double price(String goods) {
		resetCheckout();
		
		if(!"".equals(goods)) {
			
			String[] goodsSplit = goods.split("");
			
			for (String product: goodsSplit) {
				checkout.scan(product);
			}
		}
		
	    return checkout.total();
	}
	
	private void resetCheckout() {
		checkout = new Checkout(priceList);
	}
	
	@Test
	public void testTotals() {
	    assertThat(price("")      , is(closeTo(  0, 0.00001)));
	    assertThat(price("A")     , is(closeTo( 50, 0.00001)));
	    assertThat(price("AB")    , is(closeTo( 80, 0.00001)));
	    assertThat(price("CDBA")  , is(closeTo(115, 0.00001)));
	    
	    assertThat(price("AA")    , is(closeTo(100, 0.00001)));
	    assertThat(price("AAA")   , is(closeTo(130, 0.00001)));
	    assertThat(price("AAAA")  , is(closeTo(180, 0.00001)));
	    assertThat(price("AAAAA") , is(closeTo(230, 0.00001)));
	    assertThat(price("AAAAAA"), is(closeTo(260, 0.00001)));
        
	    assertThat(price("AAAB")  , is(closeTo(160, 0.00001)));
	    assertThat(price("AAABB") , is(closeTo(175, 0.00001)));
	    assertThat(price("AAABBD"), is(closeTo(190, 0.00001)));
	    assertThat(price("DABABA"), is(closeTo(190, 0.00001)));
	}
	
	@Test
	public void testIncremental() {
		assertThat(checkout.total(), is(closeTo(0, 0.00001)));
		
	    checkout.scan("A"); assertThat(checkout.total(), is(closeTo( 50, 0.00001)));
	    checkout.scan("B"); assertThat(checkout.total(), is(closeTo( 80, 0.00001)));
	    checkout.scan("A"); assertThat(checkout.total(), is(closeTo(130, 0.00001)));
	    checkout.scan("A"); assertThat(checkout.total(), is(closeTo(160, 0.00001)));
	    checkout.scan("B"); assertThat(checkout.total(), is(closeTo(175, 0.00001)));
	}

}
