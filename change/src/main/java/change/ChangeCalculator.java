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
		return toBigDecimal(billsForChange(change.doubleValue()));
	}
	
	private List<Double> billsForChange(double change) {
		List<Double> bills = new ArrayList<Double>();
		
		double remainingChange = change;
		for (int i = 0; i < availableBills.length ; i++) {
			while (remainingChange >= availableBills[i]) {
				bills.add(availableBills[i]);
				remainingChange -= availableBills[i];
			}
		}
		return bills;
	}

	private List<BigDecimal> coinsForChange(BigDecimal change) {
		return toBigDecimal(coinsForChange(change.doubleValue()));
	}
	
	private List<Double> coinsForChange(double change) {
		List<Double> coins = new ArrayList<Double>();
		
		double remainingChange = change;
		for (int i = 0; i < availableCoins.length ; i++) {
			while (remainingChange >= availableCoins[i]) {
				coins.add(availableCoins[i]);
				remainingChange -= availableCoins[i];
			}
		}
		return coins;
	}

	private List<BigDecimal> toBigDecimal(List<Double> doubleValues) {
		List<BigDecimal> bdList = new ArrayList<BigDecimal>();
		for (Double doubleValue: doubleValues) 
			bdList.add(BigDecimal.valueOf(doubleValue));
		
		return bdList;
	}
}
