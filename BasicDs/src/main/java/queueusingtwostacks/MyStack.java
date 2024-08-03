package main.java.queueusingtwostacks;

public class MyStack<T> {
    private int maxSize;
    private int top;
    private T[] array;
    private int currentSize;
     
    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        this.maxSize = size;
        this.top = -1;
        this.currentSize = 0;
        this.array = (T[]) new Object[size]; // Type erasure workaround
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public T top() {
        if (isEmpty())
            System.out.println("Stack is empty");
        return array[top];
    }

    public void push(T value) {
        if (isFull())
            throw new StackOverflowError("Stack is full");
        array[++top] = value;
        currentSize++;
    }

    public T pop() {
        if (isEmpty())
            System.out.println("Stack is empty");
        currentSize--;
        return array[top--];
    }

}
