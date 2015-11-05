package checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PriceList {

	private Map<String, Product> products = new HashMap<String, Product>();

	public void add(Product product) {
		this.products.put(product.getId(), product);
	}

	public Product find(String productId) {
		Product product = products.get(productId);
		if (product == null) {
			throw new IllegalArgumentException("Product " + productId
					+ " was not found on pricelist");
		}
		return product;
	}

	public static PriceList createDefaultPriceList() {
		PriceList priceList = new PriceList();

		Product productA = new Product("A", 50);
		productA.setSpecialPriceQuantity(3);
		productA.setSpecialPrice(130);
		priceList.add(productA);

		Product productB = new Product("B", 30);
		productB.setSpecialPriceQuantity(2);
		productB.setSpecialPrice(45);
		priceList.add(productB);

		priceList.add(new Product("C", 20));
		priceList.add(new Product("D", 15));

		return priceList;
	}

	public double getProductsPrice(Product product, int quantity) {
		return product.getPricePerQuantity(quantity);
	}

	public double calculateTotal(List<Product> products) {
		double total = 0.0;
		
		Map<Product, Integer> quantityPerProduct = getQuantityPerProduct(products);
		
		for (Entry<Product, Integer> entry : quantityPerProduct.entrySet()) {
			Product product = entry.getKey();
			Integer quantity = entry.getValue();
			
			total += getProductsPrice(product, quantity);
		}
		
		return total;
	}
	
	protected Map<Product, Integer> getQuantityPerProduct(List<Product> products) {
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
