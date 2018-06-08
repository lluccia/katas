package checkout;

public class Product {

    private String id;
    
    private Price price;
    
    private int specialPriceQuantity;
    private double specialPrice;
    
    
    public Product(String id) {
        this(id, 0.0);
    }

    public Product(String id, double unitPrice) {
        this.price = new Price();
        this.id = id;
        price.setUnitPrice(unitPrice);
    }

    public String getId() {
        return id;
    }

    public double getUnitPrice() {
        return price.getUnitPrice();
    }

    public void setUnitPrice(double unitPrice) {
        price.setUnitPrice(unitPrice);
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
