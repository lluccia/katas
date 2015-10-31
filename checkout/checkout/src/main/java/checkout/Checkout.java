package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Checkout {

	private PriceList priceList;

	public List<Product> products = new ArrayList<Product>();
	
	public Checkout(PriceList priceList) {
		this.priceList = priceList;
	}
	
	public void scan(String productId) {
		products.add(priceList.find(productId));
	}
	
	public double total() {
		double total = 0.0;
		
		Map<Product, Integer> quantityPerProduct = getQuantityPerProduct();
		
		for (Entry<Product, Integer> entry : quantityPerProduct.entrySet()) {
			Product product = entry.getKey();
			Integer quantity = entry.getValue();
			
			total += priceList.getProductsPrice(product, quantity);
		}
		
		return total;
	}

	protected Map<Product, Integer> getQuantityPerProduct() {
		Map<Product, Integer> quantityPerProduct = new HashMap<Product, Integer>();
		
		for (Product product: products) {
			Integer productTotal = quantityPerProduct.get(product);
			
			if (productTotal == null) 
				productTotal = 0;
			
			productTotal += 1;
			
			quantityPerProduct.put(product, productTotal);
		}
		
		return quantityPerProduct;
	}
}
