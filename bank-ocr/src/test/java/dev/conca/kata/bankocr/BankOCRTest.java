package dev.conca.kata.bankocr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BankOCRTest {
	
	private static final String OCR_123456789 = 
					"    _  _     _  _  _  _  _ \n" +
					"  | _| _||_||_ |_   ||_||_|\n" +
					"  ||_  _|  | _||_|  ||_| _|";
	
	private static final String OCR_12345678I = 
	          		"    _  _     _  _  _  _    \n" +
					"  | _| _||_||_ |_   ||_||_|\n" +
					"  ||_  _|  | _||_|  ||_||_|";

	private static final String DIGIT_ONE = 
					"   \n" +
					"  |\n" +
					"  |";
	
	private static final String DIGIT_TWO = 
					" _ \n" +
					" _|\n" +
					"|_ ";
	
	private static final String DIGIT_NINE = 
					" _ \n" +
					"|_|\n" +
					" _|";
	
	private OCRParser ocrParser;
	
	@Before
	public void setUp() {
		ocrParser = new OCRParser();
	}
	
	@Test
	public void canReadFirstDigit() {
		ocrParser.setEntries(OCR_123456789);
		assertEquals(DIGIT_ONE,  ocrParser.readDigit(0, OCR_123456789));
	}
	
	@Test
	public void canReadSecondDigit() {
		ocrParser.setEntries(OCR_123456789);
		assertEquals(DIGIT_TWO, ocrParser.readDigit(1, OCR_123456789));
	}
	
	@Test
	public void canReadLastDigit() {
		ocrParser.setEntries(OCR_123456789);
		assertEquals(DIGIT_NINE, ocrParser.readDigit(8, OCR_123456789));
	}
	
	@Test
	public void canParseDigitOne() {
		assertEquals("1", ocrParser.parseDigit(0, OCR_123456789));
	}
	
	@Test
	public void canParseDigitTwo() {
		assertEquals("2", ocrParser.parseDigit(1, OCR_123456789));
	}
	
	@Test
	public void canParseInvalidDigit() {
		assertEquals("?", ocrParser.parseDigit(8, OCR_12345678I));
	}

	@Test
	public void canParseEntry() {
		ocrParser.setEntries(OCR_123456789);
		assertEquals("123456789", ocrParser.parseEntry(ocrParser.getEntry(0)));
	}
	
	@Test
	public void canCheckValidAccountNumber() {
		assertTrue(ocrParser.isValid("123456789"));
	}
	
	@Test
	public void canCheckInvalidAccountNumber() {
		assertFalse(ocrParser.isValid("123456788"));
	}
	
	@Test
	public void canCheckInvalidAccountNumberWithInvalidNumbers() {
		assertFalse(ocrParser.isValid("1234?6788"));
	}
	
	private String createMultipleAccountsEntry() {
		String accountList = 
			"    _  _  _  _  _  _  _  _ \n" +
			"|_||_   ||_ | ||_|| || || |\n" +
			"  | _|  | _||_||_||_||_||_|\n" +
			"                           \n" +
			" _  _     _  _        _  _ \n" +
			"|_ |_ |_| _|  |  ||_||_||_ \n" +
			"|_||_|  | _|  |  |  | _| _|\n" +
			"                           \n" +
			" _  _        _  _  _  _  _ \n" +
			"|_||_   |  || ||  |   _||_ \n" +
			"|_||_|  |  ||_| _||_| _||_|\n" +
			"                           ";
		
		return accountList;
	}

	@Test
	public void canParseMultipleEntries() {
		ocrParser.setEntries(createMultipleAccountsEntry());
		
		assertEquals("457508000", ocrParser.parseEntry(ocrParser.getEntry(0)));
		assertEquals("664371495", ocrParser.parseEntry(ocrParser.getEntry(1)));
		assertEquals("86110??36", ocrParser.parseEntry(ocrParser.getEntry(2)));
	}
	
	@Test
	public void canPrintAccountReport() {
		String expectedReport = 
				"457508000\n" +
				"664371495 ERR\n" +
				"86110??36 ILL\n";
		
		ocrParser.setEntries(createMultipleAccountsEntry());
		
		assertEquals(expectedReport, ocrParser.printReport());
	}
}
