package Codility;

import java.util.*;

public class Bracket {
    public static int solution(String S) {
        char[] charArray = S.toCharArray();
        int n = charArray.length;
        if (n == 1) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        Deque<Character> brackets = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            if (ch == '(' || ch == '[' || ch == '{') {
                brackets.push(ch);
            } else {
                Character peekVal = brackets.peek();
                if (peekVal == null) {
                    return 0;
                }
                switch (ch) {
                    case ')':
                        if (peekVal == '(') {
                            brackets.pop();
                        } else {
                            return 0;
                        }
                        break;
                    case ']':
                        if (peekVal == '[') {
                            brackets.pop();
                        } else {
                            return 0;
                        }
                        break;
                    case '}':
                        if (peekVal == '{') {
                            brackets.pop();
                        } else {
                            return 0;
                        }
                        break;
                }
            }
        }
        if (!brackets.isEmpty())
            return 0;
        return 1;
    }

    public static int optimalSoln(String S) {
        Map<Character,Character>  characterMap = new HashMap<>();
        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: S.toCharArray()){
            if(characterMap.containsKey(c)){
                //this is ending flag
                if(stack.isEmpty()){
                    return 0;
                }
                Character character = stack.pop();
                if(!character.equals(characterMap.get(c))){
                    return 0;
                }
            }
            else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(optimalSoln(")("));
        System.out.println(optimalSoln("([)()]"));
        System.out.println(optimalSoln(""));
        System.out.println(optimalSoln("{[()()]}"));
        System.out.println(optimalSoln(" "));

    }
}
