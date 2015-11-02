package checkout;

public class Product {

	private String id;
	private double unitPrice;
	
	private int specialPriceQuantity;
	private double specialPrice;
	
	public Product(String id) {
		this(id, 0.0);
	}

	public Product(String id, double unitPrice) {
		this.id = id;
		this.unitPrice = unitPrice;
	}

	public String getId() {
		return id;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setSpecialPriceQuantity(int specialPriceQuantity) {
		this.specialPriceQuantity = specialPriceQuantity;
	}

	public void setSpecialPrice(double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Integer getSpecialPriceQuantity() {
		return specialPriceQuantity;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public boolean hasSpecialPrice() {
		return specialPriceQuantity > 0;
	}

	public double getPricePerQuantity(int quantity) {
		double productsPrice = 0;
		
		if (!hasSpecialPrice() || quantity < getSpecialPriceQuantity())
			productsPrice = quantity * getUnitPrice();
		else {
			int packsQuantity = quantity / getSpecialPriceQuantity();
			productsPrice = packsQuantity * getSpecialPrice();
			
			int remainder = quantity % getSpecialPriceQuantity();
			productsPrice += remainder * getUnitPrice();
		}
		
		return productsPrice;
	}

}
