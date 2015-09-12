package dev.conca.kata.romannumerals.fixture;

import dev.conca.kata.romannumerals.converter.IntegerToRomanConverter;
import fit.ColumnFixture;

public class RomanNumerals extends ColumnFixture {
	
	private IntegerToRomanConverter converter = new IntegerToRomanConverter();
	public Integer integer;
	
	public void setInteger(Integer integerValue) {
		this.integer = integerValue;
	}
	
	public String roman() {
		return converter.convert(integer);
	}
}
