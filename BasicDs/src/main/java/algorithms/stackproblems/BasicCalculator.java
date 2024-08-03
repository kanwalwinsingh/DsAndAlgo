package main.java.algorithms.stackproblems;

import java.util.Stack;

public class BasicCalculator {
    public static int calculator(String expression) {
       int len = expression.length();
       int sign =1, result =0;
       Stack<Integer> stack = new Stack<>();
       for(int i =0; i< len; i++) {
           if (Character.isDigit(expression.charAt(i))){
               int sum  = expression.charAt(i) - '0';
               while (i+1<len && Character.isDigit(expression.charAt(i+1))){
                   sum = sum*10 + expression.charAt(i+1)-'0';
                   i++;
               }
               result +=sum*sign;
           } else if (expression.charAt(i) == '+') {
               sign = 1;
           } else if (expression.charAt(i) == '-') {
               sign = -1;
           } else if (expression.charAt(i) == '(') {
               stack.push(result);
               stack.push(sign);
               result =0;
               sign = 1;
           } else if (expression.charAt(i) == ')') {
               result = result*stack.pop() + stack.pop();
           }

       }
       return result;
    }
    public static void main(String args[]) {
        String[] input = {
                "4 + (52 - 12) + 99",
                "(31 + 7) - (5 - 2)",
                "(12 - 9 + 4) + (7 - 5)",
                "8 - 5 + (19 - 11) + 6 + (10 + 3)",
                "56 - 44 - (27 - 17 - 1) + 7"
        };
        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + "." + "\tGiven Expression: " + input[i]);
            System.out.println("\tThe result is:  " + calculator(input[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
