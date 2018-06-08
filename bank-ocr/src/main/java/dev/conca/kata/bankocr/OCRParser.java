package dev.conca.kata.bankocr;

import java.util.ArrayList;
import java.util.List;

public class OCRParser {

    private List<String> ocrEntries = new ArrayList<String>();
    
    private static final String OCR_DIGITS = 
            " _     _  _     _  _  _  _  _ \n" +
            "| |  | _| _||_||_ |_   ||_||_|\n" +
            "|_|  ||_  _|  | _||_|  ||_| _|";
    
    private String[] ocrDigits;
    
    public OCRParser() {
        ocrDigits = new String[10];
        
        for (int i = 0 ; i < 10; i++)
            ocrDigits[i] = readDigit(i, OCR_DIGITS);
    }
            
    public void setEntries(String ocrEntry) {
        String[] lines = ocrEntry.split("\n");
        
        String entry = "";
        for (int lineCounter = 0; lineCounter < lines.length; lineCounter += 4) {
            entry += lines[lineCounter] + "\n";
            entry += lines[lineCounter+1] + "\n";
            entry += lines[lineCounter+2];
            ocrEntries.add(entry);

            entry = "";
        }
    }
    
    public String getEntry(int line) {
        return ocrEntries.get(line);
    }

    public String parseEntry(String ocrEntry) {
        String entry = "";
        for (int i = 0; i < 9; i++)
            entry += parseDigit(i, ocrEntry);

        return entry;
    }
    
    public String parseDigit(int position, String ocrEntry) {
        String digit = readDigit(position, ocrEntry);
        
        for (Integer i = 0; i < ocrDigits.length; i++)
            if (ocrDigits[i].equals(digit))
                return i.toString();
        
        return "?";
    }

    public String readDigit(int position, String ocrEntry) {
        String[] lines = ocrEntry.split("\n");
        
        String digit = "";
        for (String line : lines) {
            digit += line.substring(0 + position*3, 3 + position*3) + "\n";
        }
        digit = digit.substring(0, digit.length()-1);
        
        return digit;
    }

    public boolean isValid(String accountNumber) {
        char[] digits = accountNumber.toCharArray();
        
        if (accountNumber.contains("?"))
            return false;
        
        int sum = 0;
        for(int i = 0; i < digits.length ; i++)
            sum += Integer.valueOf(String.valueOf(digits[i])) * (digits.length - i);
        
        return sum % 11 == 0;
    }

    public String printReport() {
        String report = "";
        
        String account;
        for (String ocrEntry: ocrEntries) {
            account = parseEntry(ocrEntry);
            report += account; 
            report += account.contains("?") ? " ILL" : isValid(account) ? "" : " ERR"; 
            report += "\n";
        }
            
        return report;
    }

}
