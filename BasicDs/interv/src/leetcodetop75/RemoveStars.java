package leetcodetop75;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveStars {

    public String removeStars(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && ch == '*'){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        String st = "";
        while (!stack.isEmpty()){
            st+=stack.removeLast();
        }
        return st;
    }

    public String removeStarOptimalSoln(String s){
        //Use a string builder as a stack to store the resultant character
        StringBuilder stack = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '*'){
                //If the current character is *, remove the top character from the stack
                stack.deleteCharAt(stack.length()-1);
            }else{
                stack.append(c);
            }
        }

        //Convert the stack to a string and return
        return stack.toString();
    }
}
