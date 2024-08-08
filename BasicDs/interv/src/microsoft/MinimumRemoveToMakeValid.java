package microsoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValid {
    public String  minRemoveToMakeValidString(String s){
        int n = s.length();
        boolean[] toRemove = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        //First pass: Identify invalid closing parentheses
        for(int i =0; i< n; i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            } else if (c ==')') {
                if(stack.isEmpty()){
                    toRemove[i] = true;
                }else{
                    stack.pop();
                }
            }
        }

        //Mark all unmatched opening paranthesis in the stack
        while (!stack.isEmpty()){
            toRemove[stack.pop()] = true;
        }
        //Build the string
        StringBuilder result = new StringBuilder();
        for(int i =0; i<n; i++){
            if(!toRemove[i]){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }



    public static void main(String[] args) {
        MinimumRemoveToMakeValid solution = new MinimumRemoveToMakeValid();
        String s = "lee(t(c)o)de)";
        String result = solution.minRemoveToMakeValidString(s);
        System.out.println("Result: " + result); // Expected: "lee(t(c)o)de"

        s = "a)b(c)d";
        result = solution.minRemoveToMakeValidString(s);
        System.out.println("Result: " + result); // Expected: "ab(c)d"

        s = "))((";
        result = solution.minRemoveToMakeValidString(s);
        System.out.println("Result: " + result); // Expected: ""
    }
}
