package dev.conca.kata.stack;

/**
 * Created by leandro on 24/09/15.
 */
public class Stack {

    private int[] stack = new int[20];
    private int size = 0;

    public void push(int i) {
        if (size == stack.length)
            throw new StackOverflowException();

        stack[size++] = i;
    }

    public int pop() {
        if(size == 0)
            throw new StackEmptyException();

        return stack[--size];
    }

    public int size() {
        return size;
    }

    public class StackEmptyException extends RuntimeException {
    }

    public class StackOverflowException extends RuntimeException {
    }
}
