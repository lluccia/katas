import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void emptyStringShouldReturnZero() {
        assertEquals(0, add(""));
    }

    @Test
    public void addingOneNumberShouldReturnItself() {
        assertEquals(1, add("1"));
    }

    @Test
    public void addingTwoNumbersShouldReturnItsSum() {
        assertEquals(3, add("1,2"));
    }

    @Test
    public void addingFiveNumbersShouldReturnItsSum() {
        assertEquals(15, add("1,2,3,4,5"));
    }

    @Test
    public void newLineCanBeUsedAsSeparator() {
        assertEquals(15, add("1,2\n3,4\n5"));
    }

    @Test
    public void canDefineDelimiterInFirstLine() {
        assertEquals(";", getDelimiter("//;\n1;2"));
    }

    @Test
    public void canAddNumbersWithCustomDelimiter() {
        assertEquals(3, add("//;\n1;2"));
    }

    @Test
    public void addingNegativeNumbersShouldThrowException() {
        try {
            add("//;\n-1;-2");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -1,-2", e.getMessage());
        }
    }

    private int add(String calcString) {
        if ("".equals(calcString)) {
            return 0;
        } else {
            String delimiter = getDelimiter(calcString);
            String[] operands = getOperands(calcString).split(delimiter);
            validateOperands(operands);
            int sum = 0;

            for (String operand: operands)
                sum += Integer.valueOf(operand);

            return sum;
        }
    }

    private void validateOperands(String[] operands) {
        List<String> invalidOperands = new ArrayList<>();
        for (String operand: operands)
            if (Integer.valueOf(operand) < 0)
                invalidOperands.add(operand);

        if (invalidOperands.size() > 0) {
            String invalidOperandsMsg = "Negatives are not allowed: ";
            for (String invalidOperand: invalidOperands) {
                invalidOperandsMsg += invalidOperand + ",";
            }
            invalidOperandsMsg = invalidOperandsMsg.substring(0, invalidOperandsMsg.length() - 1);
            throw new IllegalArgumentException(invalidOperandsMsg);
        }
    }

    private String getDelimiter(String calcString) {
        if(hasDelimiterSpecifier(calcString))
            return calcString.substring(2,3);
        else
            return "[,\\n]";
    }

    private String getOperands(String calcString) {
        if (hasDelimiterSpecifier(calcString))
            return calcString.substring(4);
        else
            return calcString;
    }

    private boolean hasDelimiterSpecifier(String operands) {
        return operands.startsWith("//");
    }
}
