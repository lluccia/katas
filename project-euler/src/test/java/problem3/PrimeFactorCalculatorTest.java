package problem3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeFactorCalculatorTest {

    private PrimeFactorsCalculator primeFactorsCalculator;

    @Before
    public void setUp() {
        primeFactorsCalculator = new PrimeFactorsCalculator();
    }

    @Test
    public void testInitialPrimeNumbersSequence() {
        List<Long> primeNumbersSequence = new ArrayList<>();

        primeNumbersSequence.add(primeFactorsCalculator.getCurrentPrime());
        for (int i = 0; i < 18; i++) {
            primeNumbersSequence.add(primeFactorsCalculator.incrementPrime());
        }

        Assert.assertArrayEquals(
                new Long[] { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L },
                primeNumbersSequence.toArray());
    }

    @Test
    public void testIsPrime() {
        Assert.assertTrue(primeFactorsCalculator.isPrime(17L));
    }

    @Test
    public void testIsNotPrime() {
        Assert.assertFalse(primeFactorsCalculator.isPrime(16L));
    }

    @Test
    public void testPrimeFactorsCalculation() {
        List<Long> primeFactors = primeFactorsCalculator.decompose(13195L);
        Assert.assertArrayEquals(new Long[] { 5L, 7L, 13L, 29L }, primeFactors.toArray());
    }

}
