package main.java.twostacksusingarray;

public class TwoStacks<V> {
    private int arraySize;
    private int top1, top2;
    private V[] array;

    public TwoStacks(int arraySize) {
        this.arraySize = arraySize;
        this.top1 = -1;
        this.top2 = arraySize;
        array = (V[]) new Object[arraySize];
    }

    public void push1(V value) {
        // Incement top pointer and add element to stack 1 if space is available
        if (top1 < top2 - 1) {
            array[++top1] = value;
        } else {
            System.out.println("Stack overflow");
            System.exit(1);
        }
    }

    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        } else {
            System.out.println("stack overflow");
            System.exit(1);
        }
    }

    // Return and remove top element from stack 1 if not empty
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        } else {
            System.out.println("Stack overflow");
            System.exit(1);
            return null;
        }
    }

    public V pop2() {
        if (top2 < arraySize) {
            return array[top2++];
        } else {
            System.out.println("Stack overflow");
            System.exit(1);
            return null;
        }
    }
}
