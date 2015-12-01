package change;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ChangeTest {

	private ChangeCalculator changeCalculator = new ChangeCalculator();
	
	@Test
	public void changeCalculation() {
		assertThat(changeCalculator.changeFor(BigDecimal.valueOf(10.00), BigDecimal.valueOf(10.00)), is(BigDecimal.valueOf(0.0)));
		assertThat(changeCalculator.changeFor(BigDecimal.valueOf(4.32), BigDecimal.valueOf(10.00)), is(BigDecimal.valueOf(5.68)));
	}

	@Test
	public void noChange() {
		changeCalculator.calculateBillsAndCoins(0.00);
		assertThat(changeCalculator.getBills(), is(listOf()));		
		assertThat(changeCalculator.getCoins(), is(listOf()));		
	}
	
	@Test
	public void oneHundredChange() {
		changeCalculator.calculateBillsAndCoins(100.00);
		assertThat(changeCalculator.getBills(), is(listOf(100.0)));		
		assertThat(changeCalculator.getCoins(), is(listOf()));		
	}
	
	@Test
	public void fiftyCentChange() {
		changeCalculator.calculateBillsAndCoins(0.50);
		assertThat(changeCalculator.getBills(), is(listOf()));		
		assertThat(changeCalculator.getCoins(), is(listOf(0.50)));		
	}
	
	@Test
	public void twoHundredChange() {
		changeCalculator.calculateBillsAndCoins(200.00);
		assertThat(changeCalculator.getBills(), is(listOf(100.00, 100.00)));		
		assertThat(changeCalculator.getCoins(), is(listOf()));		
	}

	@Test
	public void threeHundredChange() {
		changeCalculator.calculateBillsAndCoins(300.00);
		assertThat(changeCalculator.getBills(), is(listOf(100.00, 100.00, 100.00)));		
		assertThat(changeCalculator.getCoins(), is(listOf()));		
	}
	
	@Test
	public void allBillsChange() {
		changeCalculator.calculateBillsAndCoins(166.00);
		assertThat(changeCalculator.getBills(), is(listOf(100.00, 50.00, 10.00, 5.00, 1.00)));		
		assertThat(changeCalculator.getCoins(), is(listOf()));		
	}
	
	@Test
	public void allCoinsChange() {
		changeCalculator.calculateBillsAndCoins(0.66);
		assertThat(changeCalculator.getBills(), is(listOf()));		
		assertThat(changeCalculator.getCoins(), is(listOf(0.50, 0.10, 0.05, 0.01)));		
	}
	
	@Test
	public void mixedChange() {
		changeCalculator.calculateBillsAndCoins(166.66);
		assertThat(changeCalculator.getBills(), is(listOf(100.00, 50.00, 10.00, 5.00, 1.00)));		
		assertThat(changeCalculator.getCoins(), is(listOf(0.50, 0.10, 0.05, 0.01)));		
	}
	
	private List<BigDecimal> listOf(Double... doubleValues) {
		List<BigDecimal> bdList = new ArrayList<BigDecimal>();
		for (Double doubleValue: doubleValues) 
			bdList.add(BigDecimal.valueOf(doubleValue));
		
		return bdList;
	}

}
