package main.java.validparantheses;

import main.java.reversefirstkelementinqueue.MyStack;

public class Validparantheses {
    public static boolean isBalanced(String exp){
        MyStack<Character> stack = new MyStack<>();
        for(int i =0; i<exp.length(); i++){
            char character = exp.charAt(i);
            if(character == '}' || character==')' || character == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                //Pop the top element from the stack(most recent opening bracket)
                char topChar = stack.pop();

                if ((character == '}' && topChar != '{') ||
                        (character == ')' && topChar != '(') ||
                        (character == ']' && topChar != '[')) {
                    return false;
                }
            }else {
                stack.push(character);
            }
        }
        // If stack is not empty, stack contains unmatched opening parantheses
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String[] parentheses = {
                "(){}[]",
                "[{()}]",
                "]}){{()}({[",
                "[[{{((}])}])",
                "))))))"
        };

        for (int i = 0; i < parentheses.length; i++) {
            System.out.println((i + 1) + ".\tCheck balanced parentheses: '" + parentheses[i] + "'");
            boolean result = isBalanced(parentheses[i]);

            System.out.println("\tIs the string balanced? " + (result ? "True" : "False"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
