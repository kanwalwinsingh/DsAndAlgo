package expedia;

import java.util.Map;

public class MinStackUsingNode {

    private Node head;

    private static class Node {
        int value;
        int min;
        Node next;


        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    public MinStackUsingNode(){
        head = null;
    }

    public void push(int val){
        if(head == null){
            head = new Node(val,val,null);
        }else{
            head = new Node(val, Math.min(val, head.min),head);
        }
    }

    public void pop(){
        if(head != null){
            head = head.next;
        }
    }

    public int top(){
        if(head == null){
            throw new RuntimeException("Stack is empty");
        }
        return head.value;
    }

    public int getMin(){
        if(head == null){
            throw new RuntimeException("Stack is empty");
        }
        return head.min;
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
