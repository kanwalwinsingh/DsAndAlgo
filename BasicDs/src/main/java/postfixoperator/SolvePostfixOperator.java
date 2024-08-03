package main.java.postfixoperator;

import main.java.queueusingtwostacks.MyStack;

public class SolvePostfixOperator {

    public static int applyOperator(char op, int num1, int num2){
        int result =0;
        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            // Assuming integer division for simplicity
            result = num1 / num2;
        }
        return result;
    }

    public static int evaluatePostFix(String exp){
        MyStack<Integer> stack = new MyStack<>(exp.length());
        for (char c: exp.toCharArray()){
            if(Character.isDigit(c)){
                //Push number onto the stack
                stack.push(Character.getNumericValue(c));
            }else {
                //Operator encountered
                // pop two numbers from stack
                int right = stack.pop();
                int left = stack.pop();
                //Apply operator to operand and push result back to stack
                int result = applyOperator(c,left,right);
                stack.push(result);
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        String[] testCases = {"921*-8-4+", "53+62/*35*+", "543-3*+", "82/3-31*+", "92+31*-"};

        int i = 1;
        for (String caseExp : testCases) {
            System.out.println(i+ ".\tExpression: " + caseExp);
            int result = evaluatePostFix(caseExp);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i++;
        }
    }
}
