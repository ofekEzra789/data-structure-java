package stack;
import java.util.Arrays;

public class stackUsingArray {

    private int[] stack;
    private int pos = 0;

    public stackUsingArray(int size) {
        this.stack = new int[size];
    }

    public void push(int data) {
        if (pos == stack.length) {
            throw new StackOverflowError();
        } else {
            this.stack[this.pos++] = data;
        }

    }

    public int pop() {
        if (pos == 0) {
            throw new IllegalStateException();
        }
        return this.stack[--this.pos];
    }

    public int peek() {
        if (pos == 0) {
            throw new IllegalStateException();
        }
        return this.stack[this.pos-1];
    }

    public boolean isEmpty() {
        return this.pos == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, pos);
        return Arrays.toString(content);
    }

}
