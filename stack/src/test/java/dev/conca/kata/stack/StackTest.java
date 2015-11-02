package dev.conca.kata.stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void canPush() {
        stack.push(1);
    }

    @Test
    public void canPop() {
        stack.push(1);
        int i = stack.pop();
        assertEquals(1, i);
    }

    @Test
    public void canPopSecondElement() {
        stack.push(2);
        stack.push(1);

        stack.pop();
        int i = stack.pop();
        assertEquals(2, i);
    }

    @Test
    public void canGetSize() {
        stack.push(2);
        stack.push(1);

        assertEquals(2, stack.size());
    }

    @Test(expected = Stack.StackEmptyException.class)
    public void popEmptyShouldThrowException() {
        stack.pop();
    }

    @Test(expected = Stack.StackOverflowException.class)
    public void pushFullShouldThrowException() {
        for (int i = 0; i < 21; i++)
            stack.push(i);
    }

    @Test
    public void pushToSizeShouldNotThrowException() {
        for (int i = 0; i < 20; i++)
            stack.push(i);

        assertEquals(20, stack.size());
    }
}