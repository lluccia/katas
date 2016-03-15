import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Test
    public void shouldIgnoreNumbersGreaterThan1000() {
        assertEquals(2, add("1001,2"));
    }


    private int add(String calcString) {
        int sum = 0;

        for (Integer operand: getValidOperands(calcString))
            sum += operand;

        return sum;
    }

    private List<Integer> getValidOperands(String calcString) {
        if ("".equals(calcString))
            return new ArrayList<>();

        String delimiter = getDelimiter(calcString);

        String[] operandsSplit = getOperands(calcString).split(delimiter);

        List<Integer> integers = convertToInt(operandsSplit);

        validateOperands(integers);

        removeNumbersGreaterThan1000(integers);

        return integers;
    }

    private List<Integer> convertToInt(String[] operandsSplit) {
        List<Integer> integers = new ArrayList<>();
        for (String operand: operandsSplit)
            integers.add(Integer.valueOf(operand));

        return integers;
    }

    private void removeNumbersGreaterThan1000(List<Integer> operands) {
        Iterator<Integer> iterator = operands.iterator();

        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > 1000)
                iterator.remove();
        }
    }

    private void validateOperands(List<Integer> operands) {
        List<Integer> invalidOperands = new ArrayList<>();
        for (Integer operand: operands)
            if (Integer.valueOf(operand) < 0)
                invalidOperands.add(operand);

        if (invalidOperands.size() > 0) {
            String invalidOperandsMsg = "Negatives are not allowed: ";
            for (Integer invalidOperand: invalidOperands) {
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
