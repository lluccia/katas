package checkout;

public class Price {

	private double unitPrice;
	
	private int specialPriceQuantity;
	private double specialPrice;
	
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

}
