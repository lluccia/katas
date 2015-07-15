package problem3;

import java.util.List;

/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author leandro
 *
 */
public class Solution1 {
	
	private static PrimeFactorsCalculator PRIME_FACTORS_CALCULATOR = new PrimeFactorsCalculator();
	
	public static void main(String[] args) {
		List<Long> primeFactors = PRIME_FACTORS_CALCULATOR.decompose(600851475143L);
		
		System.out.println("Max prime factor = " + primeFactors.get(primeFactors.size()-1));
	}

}
