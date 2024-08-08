package microsoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKDigits(String num, int k){
        if(num.length() == k){
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char digit : num.toCharArray()){
            while (k>0 && !stack.isEmpty() && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        //Remove the remaining k digits from the end
        while (k>0){
            stack.pop();
            k--;
        }

        //Build the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.removeLast());
        }
        //Remove leading zero
        while (result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        System.out.println(solution.removeKDigits("1432219", 3)); // Output: "1219"
        System.out.println(solution.removeKDigits("10200", 1));   // Output: "200"
        System.out.println(solution.removeKDigits("10", 2));      // Output: "0"
    }
}
