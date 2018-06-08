package problem3;

import java.util.ArrayList;
import java.util.List;


public class PrimeFactorsCalculator {

    private Long currentPrime = 2L;
    
    public List<Long> decompose(Long number) {
        List<Long> factors = new ArrayList<>();
        
        findNextDivisiblePrime(number);
        
        Long remainderFactor = number;
        while(isDivisible(remainderFactor, currentPrime) && remainderFactor > 1) {
            remainderFactor = remainderFactor / currentPrime; 
            factors.add(currentPrime);
        }
        
        if (remainderFactor > 1) {
            factors.addAll(decompose(remainderFactor));
        }
        
        return factors;
    }
    
    private Long findNextDivisiblePrime(Long number) {
        while(!isDivisible(number, currentPrime)) {
            incrementPrime();
        }
        return currentPrime;
    }

    private boolean isDivisible(Long number, Long divisor) {
        return number % divisor == 0;
    }

    public Long incrementPrime() {
        while (!isPrime(++currentPrime));
        
        return currentPrime;
    }

    public boolean isPrime(Long number) {
        boolean isPrime = true;
        for (Long l = 2L; l <= number / 2; l++ ) {
            if (isDivisible(number,l)) isPrime = false;
        }
        return isPrime;
    }

    public Long getCurrentPrime() {
        return currentPrime;
    }

}
