package main.java.algorithms.slowandfastpointer;

import com.sun.source.tree.BreakTree;

public class HappyNumber {
    public static int sumOfSquaredDigit(int number){
        int totalSum = 0;
        while (number>0){
            int digit = number%10;
            number = number/10;
            totalSum += (int) Math.pow(digit,2);
        }
        return totalSum;
    }

    public static boolean isHappyNumber(int n){
        int slowPointer = n;
        int fastPointer = sumOfSquaredDigit(n);
        while (fastPointer!=1 && slowPointer != fastPointer) {
            slowPointer = sumOfSquaredDigit(slowPointer);
            fastPointer = sumOfSquaredDigit(sumOfSquaredDigit(fastPointer));
        }
        return fastPointer == 1;
    }

    public static void main(String args[]) {
        int a[] = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
