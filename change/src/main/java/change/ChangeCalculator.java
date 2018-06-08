package change;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChangeCalculator {
    
    private double[] availableBills = {100.00, 50.00, 10.00, 5.00, 1.00};
    private double[] availableCoins = {0.50, 0.10, 0.05, 0.01};
    
    private List<BigDecimal> bills;
    private List<BigDecimal> coins;

    public BigDecimal changeFor(BigDecimal paid, BigDecimal total) {
        return total.subtract(paid);
    }

    public void calculateBillsAndCoins(double change) {
        calculateBillsAndCoins(BigDecimal.valueOf(change));
    }
    
    public void calculateBillsAndCoins(BigDecimal change) {
        this.bills = billsForChange(change);
        
        BigDecimal billsTotals = BigDecimal.ZERO;
        for (BigDecimal bill : bills) {
            billsTotals = billsTotals.add(bill);
        }
        
        BigDecimal remainingChange = change.subtract(billsTotals);
        
        this.coins = coinsForChange(remainingChange);
    }

    public List<BigDecimal> getBills() {
        return bills;
    }

    public List<BigDecimal> getCoins() {
        return coins;
    }

    private List<BigDecimal> billsForChange(BigDecimal change) {
        List<BigDecimal> bills = new ArrayList<BigDecimal>();
        
        BigDecimal remainingChange = change;
        for (int i = 0; i < availableBills.length ; i++) {
            BigDecimal currentBill = BigDecimal.valueOf(availableBills[i]);
            while (remainingChange.compareTo(currentBill) >= 0) {
                bills.add(currentBill);
                remainingChange = remainingChange.subtract(currentBill);
            }
        }
        return bills;
    }

    private List<BigDecimal> coinsForChange(BigDecimal change) {
        List<BigDecimal> coins = new ArrayList<BigDecimal>();
        
        BigDecimal remainingChange = change;
        for (int i = 0; i < availableCoins.length ; i++) {
            BigDecimal currentBill = BigDecimal.valueOf(availableCoins[i]);
            while (remainingChange.compareTo(currentBill) >= 0) {
                coins.add(currentBill);
                remainingChange = remainingChange.subtract(currentBill);
            }
        }
        return coins;
    }
}
