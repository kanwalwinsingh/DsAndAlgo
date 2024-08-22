package expedia;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack(){
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val){
        stack.push(val);
        //Push to minStack only if the number is minimum
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            int removed = stack.pop();
            //Pop from minStack only if it's the current minimum
            if(removed == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // Returns -3
        minStack.pop();
        System.out.println(minStack.top());     // Returns 0
        System.out.println(minStack.getMin());  // Returns -2
    }

}
