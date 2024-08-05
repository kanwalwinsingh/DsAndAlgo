package Codility;

public class AlternativeSolution {
    public static int countDivisibleBy3(String s) {
        int n = s.length();
        int originalSum = 0;

        // Calculate the original sum of digits
        for (int i = 0; i < n; i++) {
            originalSum += s.charAt(i) - '0';
        }

        int count = 0;
        int remainder = originalSum % 3;
        if(originalSum % 3 == 0){
            count++;
        }

        // Try changing each digit to every other digit (0 to 9)
        for (int i = 0; i < n; i++) {
            int currentDigit = s.charAt(i) - '0';

            for (int newDigit = 0; newDigit <= 9; newDigit++) {
                if (newDigit != currentDigit) {
                    // Calculate the change in the sum
                    int change = newDigit - currentDigit;

                    // Check if the new sum is divisible by 3
                    if ((originalSum + change) % 3 == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static int countDivisibleBy3N(String s) {
        int init = 0;
        for (char ch : s.toCharArray()){
            init = init + (ch-'0');
        }

        int count = 0;
        if(init % 3 == 0){
            count++;
        }
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';

            for (int newDigit = 0; newDigit <= 9; newDigit++) {
                if (newDigit != currentDigit) {
                    // Check if the new sum is divisible by 3
                    if ((init + (newDigit - currentDigit)) % 3 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDivisibleBy3N("23"));     // Output: 7
        System.out.println(countDivisibleBy3N("0081"));   // Output: 11
        System.out.println(countDivisibleBy3N("022"));    // Output: 9
    }
}