package main.java.queueusingtwostacks;

public class QueueWithStack {
    MyStack<Integer> stack1;
    MyStack<Integer> stack2;

    public QueueWithStack(int maxSize){
        stack1 = new MyStack<>(maxSize);
        stack2 = new MyStack<>(maxSize);
    }

    public boolean isEmpty(){
        return  stack1.isEmpty();
    }

    public void enqueue(int value){
        stack1.push(value);
    }

    public int dequeue(){
        //Traverse stack1 and pop all elements in stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // pop from stack2 (which was at the end of stack1)
        int result = stack2.pop();
        // put all elemenents back in stack1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
