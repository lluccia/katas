package checkout;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

	private PriceList priceList;

	private List<Product> products = new ArrayList<Product>();
	
	public Checkout(PriceList priceList) {
		this.priceList = priceList;
	}
	
	public void scan(String productId) {
		products.add(priceList.find(productId));
	}
	
	public double total() {
		return priceList.calculateTotal(products);
	}

}
