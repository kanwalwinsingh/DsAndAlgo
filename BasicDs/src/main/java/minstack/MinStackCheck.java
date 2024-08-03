package main.java.minstack;

import main.java.queueusingtwostacks.MyStack;

public class MinStackCheck {
    int maxSize;
    MyStack<Integer> mainStack;
    MyStack<Integer> minStack;

    public MinStackCheck(int maxSize) {
        this.maxSize = maxSize;
        mainStack = new MyStack<>(maxSize);
        minStack = new MyStack<>(maxSize);
    }

    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public void push(Integer value) {
        mainStack.push(value);
        if (minStack.isEmpty() || minStack.top() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.top());
        }
    }

    public int min() {
        return minStack.top();
    }

    public static void main(String args[]) {

        String[][] calls = {{"MinStack", "push()", "push()", "min()", "pop()"},
                {"MinStack", "push()", "pop()", "push()", "min()"},
                {"MinStack", "push()", "push()", "push()", "push()", "pop()", "min()"},
                {"MinStack", "push()", "min()", "push()"},
                {"MinStack", "push()", "push()", "min()", "push()", "min()"}};

        int[][] inputs = {{Integer.MAX_VALUE, 3, 7, Integer.MAX_VALUE, 7},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 100, 300, -200, -140, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 100000, Integer.MAX_VALUE, -100000},
                {Integer.MAX_VALUE, 54, 89, Integer.MAX_VALUE, 45, Integer.MAX_VALUE}};

        int[] sizes = {5, 5, 7, 4, 6};

        for (int i = 0; i < calls.length; i++) {
            MinStackCheck stack = new MinStackCheck(sizes[i]);

            System.out.println("\t Starting operations: ");

            for (int j = 0; j < calls[i].length; j++) {
                if (calls[i][j].equals("push()")) {
                    String inputString = "push(" + inputs[i][j] + ")";
                    System.out.println("\t\t" + inputString);
                    stack.push(inputs[i][j]);
                } else if (calls[i][j].equals("pop()")) {
                    System.out.println("\t\tpop()   returns " + stack.pop());
                } else if (calls[i][j].equals("min()")) {
                    System.out.println("\t\tmin()   returns " + stack.min());
                }
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


    }
}
