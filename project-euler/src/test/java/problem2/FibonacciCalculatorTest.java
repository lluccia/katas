package problem2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciCalculatorTest {

	private FibonacciCalculator fibonacciCalculator;
	
	@Before
	public void setUp() {
		fibonacciCalculator = new FibonacciCalculator();
	}
	
	@Test
	public void testInitialSequenceNumbers() {
		List<Integer> fibonnacciSequence = new ArrayList<>();
		
		for (int i = 0; i < 10;i++) {
			fibonnacciSequence.add(fibonacciCalculator.getNext());
		}
		
		Assert.assertArrayEquals(new Integer[] {1, 2, 3, 5, 8, 13, 21, 34, 55, 89}, fibonnacciSequence.toArray());
	}
}
