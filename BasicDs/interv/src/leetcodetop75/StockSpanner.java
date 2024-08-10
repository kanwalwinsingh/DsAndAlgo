package leetcodetop75;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    private Deque<int[]> stack;
    private int index;

    //Initialize the stock spanner object
    public StockSpanner(){
        stack  = new ArrayDeque<>();
        index =-1;
    }

    //Returns the span of the stock's price given today's price
    public int next(int price){
        index++;

        //Pop element from stack iff current price is greater than or equal to the price at the top of stack
        while (!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int span;
        if(stack.isEmpty()){
            //If stack is empty, it means current price is the highest so ffar
            span = index + 1;
        }else{
            //Otherwise, calculate the span as the difference between current index and index of the price at stack top
            span = index- stack.peek()[1];
        }
        // Push the current price and its index onto the stack
        stack.push(new int[]{price,index});
        return span;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}
