package problem4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LargestPalindromeProductTest {

	@Test
	public void testIsPalindrome() {
		assertTrue(isPalindrome("1"));
		assertTrue(isPalindrome("11"));
		assertFalse(isPalindrome("12"));
		assertTrue(isPalindrome("121"));
		assertTrue(isPalindrome("1221"));
		assertFalse(isPalindrome("1241"));
		assertTrue(isPalindrome("12345654321"));
		assertFalse(isPalindrome("12345664321"));
	}
	
	@Test
	public void testLargestInteger() {
		assertThat(largestIntegerWithDigits(2), is(99));
		assertThat(largestIntegerWithDigits(4), is(9999));
	}
	
	@Test
	public void testLargestNineNumber() {
		assertThat(largestNineNumber(1), is(0));
		assertThat(largestNineNumber(2), is(90));
		assertThat(largestNineNumber(4), is(9000));
	}
	
	private Integer largestNineNumber(int digits) {
		String largestNineNumber = digits > 1 ? "9" : "0";
		for (int i=1; i<digits; i++)
			largestNineNumber+="0";
		return Integer.valueOf(largestNineNumber);
	}

	@Test
	public void testLargestPalindromeProduct() {
		assertThat(largestPalindrome(1), is(9));
		assertThat(largestPalindrome(2), is(9009));
		assertThat(largestPalindrome(3), is(906609));
		assertThat(largestPalindrome(4), is(99000099));
	}
	
	private Integer largestPalindrome(int digits) {
		Integer largestIntegerWithDigits = largestIntegerWithDigits(digits);
		Integer lowerBoundary = 0;
		
		Integer largestProduct = 1;
		for (int i = largestIntegerWithDigits; i>lowerBoundary; i--) {
			for (int j = largestIntegerWithDigits; j>lowerBoundary; j--) {
				int product = i*j;
				if(product > largestProduct) {
					if(isPalindrome(product)) {
						if (largestProduct != Math.max(largestProduct, product)) {
							largestProduct = Math.max(largestProduct, product);
							System.out.println(String.format("largest: %d palindrome product: %d * %d", largestProduct, i, j));
						}
					}
				} else {
					continue;
				}
			}
		}
		
		System.out.println(String.format("digits: %d largestProduct: %d", digits, largestProduct));
		
		return largestProduct;
	}

	private boolean isPalindrome(Integer number) {
		return isPalindrome(number.toString());
	}



	private Integer largestIntegerWithDigits(int digits) {
		String largestInteger = "";
		for (int i=0; i<digits; i++)
			largestInteger+="9";
		return Integer.valueOf(largestInteger);
	}

	private boolean isPalindrome(String number) {
		char[] digits = number.toCharArray();

		for(int i=0; i < digits.length/2; i++)
			if (digits[i] != digits[digits.length-1-i])
				return false;
		
		return true;
	}

}
