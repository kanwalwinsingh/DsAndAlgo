package leetcodetop75;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> intStack = new ArrayDeque<>();
        int k =0;
        char[] chars = s.toCharArray();
        for(int i =0; i<chars.length; i++){
            char c = chars[i];
            if(Character.isDigit(c)){
                k = (k*10) +(c-'0');
            }else if(c=='['){
                intStack.push(k);
                k =0;
                stringStack.push(String.valueOf(c));
            }
           else if(c !=']'){
                stringStack.push(String.valueOf(c));
            }else {
                StringBuilder temp = new StringBuilder();
                while (!stringStack.peek().equals("[")) {
                    temp.insert(0, stringStack.pop());
                }
                stringStack.pop();
                StringBuilder replacment = new StringBuilder();
                int count = intStack.pop();
                for (int j = 0; j < count; j++) {
                    replacment.append(temp);
                }
                stringStack.push(replacment.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stringStack.isEmpty()){
            result.insert(0,stringStack.pop());
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
