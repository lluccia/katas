package checkout;

import java.util.HashMap;
import java.util.Map;

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
		double productsPrice = 0;
		
		if (!product.hasSpecialPrice() || quantity < product.getSpecialPriceQuantity())
			productsPrice = quantity * product.getUnitPrice();
		else {
			int packsQuantity = quantity / product.getSpecialPriceQuantity();
			productsPrice = packsQuantity * product.getSpecialPrice();
			
			int remainder = quantity % product.getSpecialPriceQuantity();
			productsPrice += remainder * product.getUnitPrice();
		}
		
		return productsPrice;
	}

}
