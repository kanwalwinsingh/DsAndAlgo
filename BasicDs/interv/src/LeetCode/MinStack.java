package LeetCode;

class MinStack {
 private class Node{
     int value;
     int min;
     Node next;
     Node(int value, int min){
         this.value = value;
         this.min = min;
     }
 }
 private Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val,val);
        }else{
            Node newNode = new Node(val,Math.min(val,head.min));
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void pop() {
        if(head != null){
            head = head.next;
        }
    }
    
    public int top() {
        if(head != null) {
            return head.value;
        }
        throw new IllegalStateException("Stack is empty");
    }
    
    public int getMin() {
        if(head != null){
            return head.min;
        }
        throw new IllegalStateException("Stack is empty");
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }
}