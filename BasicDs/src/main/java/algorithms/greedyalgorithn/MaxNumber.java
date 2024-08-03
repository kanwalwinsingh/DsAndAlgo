package main.java.algorithms.greedyalgorithn;

import java.util.Map;

public class MaxNumber {
    public static int findSumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;

        }
        return sum;
    }

    public static void findLargestNumber(int numberOfDigits, int sumOfDigits) {
        int max = 0;
        int startRange = (int) Math.pow(10, (numberOfDigits - 1));
        int endRange = (int) Math.pow(10, numberOfDigits);
        if (sumOfDigits == 0) {
            if (numberOfDigits == 1)
                System.out.println("Largest number is " + 0);
            else
                System.out.println("Largest number is not possible");
            return;
        }
        //sumOfDigits is greater than the maximum possible sum.
        if (sumOfDigits > 9 * numberOfDigits) {
            System.out.println("Largest number is Not possible");
            return;
        }
        while (startRange < endRange) {
            if (findSumOfDigit(startRange) == sumOfDigits) {
                if (max < startRange) {
                    max = startRange;
                }
            }
            startRange++;
        }
        System.out.println("Largest number is max: " + max);
    }

    public static void findLargestNumberUsingGreedyTechnique(int number_of_digits, int sum_of_digits){
        int[] result = new int[number_of_digits];
        if(sum_of_digits == 0){
            if(number_of_digits == 1){
                System.out.println(0);
            }else {
                System.out.println("None");
            }
            return;
        }
        //sum of digit is greater than max possible sum
        if(sum_of_digits> 9*number_of_digits){
            System.out.println("None");
            return;
        }
        //Fill from most significant digit to least significant digit
        for(int i =0; i<number_of_digits; i++){
            //Place 9 to make the number largest
            if(sum_of_digits >= 9){
                result[i] = 9;
                sum_of_digits-=9;
            }else{ // if remaining sum become less than 9, then fill the remaining sum
                result[i] = sum_of_digits;
                sum_of_digits = 0;
            }
        }
        for(int i =0; i<number_of_digits; i++){
            System.out.println(result[i]);
        }
    }


    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        MaxNumber.findLargestNumberUsingGreedyTechnique(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        MaxNumber.findLargestNumberUsingGreedyTechnique(numberOfDigits, sumOfDigits);

    }
}
