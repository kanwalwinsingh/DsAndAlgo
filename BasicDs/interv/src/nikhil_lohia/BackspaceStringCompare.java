package nikhil_lohia;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character ch : s.toCharArray()) {
            switch (ch) {
                case '#':
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(ch);
            }
        }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            s = sb.toString();

        for(Character ch : t.toCharArray()) {
            switch (ch) {
                case '#':
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(ch);
            }
        }
            sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            t = sb.toString();

        return s.equals(t);
    }

    public static boolean backSpaceCompareOptimized(String s, String t){
       return getActualString(s).equals(getActualString(t));
    }
    private static String getActualString(String input){
        int hashCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i =input.length() -1; i>= 0; i--){
            if(input.charAt(i) == '#'){
                hashCount++;
                continue;
            }
            if(hashCount>0){
                hashCount--;
            }else {
                sb.insert(0,input.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(backSpaceCompareOptimized("a##c","#a#c"));
    }
}
