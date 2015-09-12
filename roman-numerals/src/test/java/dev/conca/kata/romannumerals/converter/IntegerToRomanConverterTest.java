package dev.conca.kata.romannumerals.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerToRomanConverterTest {

	private IntegerToRomanConverter converter;
	
	@Before
	public void setUp() {
		converter = new IntegerToRomanConverter();
	}
	
	@Test
	public void testOneConversion() {
		Assert.assertEquals("I", converter.convert(1));
	}
	
	@Test
	public void testTwoConversion() {
		Assert.assertEquals("II", converter.convert(2));
	}
	
	@Test
	public void testFourConversion() {
		Assert.assertEquals("IV", converter.convert(4));
	}
	
	@Test
	public void testFiveConversion() {
		Assert.assertEquals("V", converter.convert(5));
	}
		
	@Test
	public void testSixConversion() {
		Assert.assertEquals("VI", converter.convert(6));
	}
	
	@Test
	public void testNineConversion() {
		Assert.assertEquals("IX", converter.convert(9));
	}
	
	@Test
	public void testTenConversion() {
		Assert.assertEquals("X", converter.convert(10));
	}
	
	@Test
	public void testTwentyConversion() {
		Assert.assertEquals("XX", converter.convert(20));
	}

}
