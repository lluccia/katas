package dev.conca.kata.romannumerals.converter;

public class IntegerToRomanConverter {

	private int[] numerals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	public String convert(int integerValue) {
		StringBuilder romanNumeral = new StringBuilder();

		int remainder = integerValue;
		int index = 0;

		while (index < numerals.length) {

			int currentValue = numerals[index];

			if (remainder >= currentValue) {
				int algarismRepetitions = remainder / currentValue;
				remainder -= (currentValue * algarismRepetitions);
				
				for (int algarism = 0; algarism < algarismRepetitions; algarism++) {
					romanNumeral.append(romans[index]);
				}
			}
			index++;
		}

		return romanNumeral.toString();
	}

}
