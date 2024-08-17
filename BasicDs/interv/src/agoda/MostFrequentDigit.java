package agoda;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentDigit {
    public static int findMostFrequentDigit(long number){
        //Map to store the frequency of each digit
        Map<Integer,Integer> digitCount = new HashMap<>();

        //Convert the number to its absolute value to handle negative numbers
        number = Math.abs(number);

        // Traverse through each digit of the number
        while (number >0){
            int digit = (int) (number%10); // Extract the last digiit
            digitCount.put(digit,digitCount.getOrDefault(digit,0)+1);
            number /=10; // Remove the last digit
        }

        //Find the digit with the maximum frequency
        int mostFrequencyDigit = -1;
        int maxFrequency = -1;
        for(Map.Entry<Integer,Integer> entry : digitCount.entrySet()){
            if(entry.getValue() > maxFrequency){
                maxFrequency = entry.getValue();
                mostFrequencyDigit = entry.getKey();
            }
        }
        return mostFrequencyDigit;
    }
    public static void main(String[] args) {
        long number = 1223334444L;
        int mostFrequentDigit = findMostFrequentDigit(number);
        System.out.println("The most frequent digit in the number is: " + mostFrequentDigit);
    }
}
