package main.java.twostacksusingarray;

import main.java.queueusingtwostacks.MyStack;

import java.util.Stack;

public class CheckSort {

    public static MyStack<Integer> sortStack(MyStack<Integer> stack){
        MyStack<Integer> tempStack = new MyStack<>(stack.getMaxSize());
        while (!stack.isEmpty()){
            Integer value = stack.pop();
            // If value is not none and larger, Push it at the top of temp_stack
            if(!tempStack.isEmpty() && value >= tempStack.top()){
                tempStack.push(value);
            }else{
                while (!tempStack.isEmpty() && tempStack.top()>value) {
                    stack.push(tempStack.pop());
                }
                    //place value as the smallest element in the temp stack
                    tempStack.push(value);
            }
        }
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return stack;
    }

    public static void insert(MyStack<Integer> stack, int value){
        if(stack.isEmpty() || value< stack.top()){
            stack.push(value);
        }else{
            int temp = stack.pop();
            insert(stack,temp);
            stack.push(value);
        }
    }

    public static MyStack<Integer> sortStackR(MyStack<Integer> stack){
        if(!stack.isEmpty()){
            // Pop the top element off the stack
            int value = stack.pop();
            // sort the remaining stack recursively
            sortStackR(stack);
            //Push the top element back into sorted stack
            insert(stack,value);
        }
        return stack;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {10, 30, 5, 20, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, -1},
                {12},
                {1, -2}
        };

        for (int[] stackValues : inputs) {
            MyStack<Integer> stack = new MyStack<>(stackValues.length);
            for (int value : stackValues) {
                stack.push(value);
            }
            System.out.print("Original Stack: [");
            for (int i = 0; i < stackValues.length; i++) {
                System.out.print(stackValues[i]);
                if (i < stackValues.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            MyStack<Integer> sortedStack = sortStackR(stack);
            System.out.print("Sorted Stack: [");
            while (!sortedStack.isEmpty()) {
                System.out.print(sortedStack.pop());
                if (!sortedStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]\n" + new String(new char[75]).replace('\0', '-'));
        }
    }
}

