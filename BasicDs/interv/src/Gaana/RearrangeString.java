package Gaana;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public static String rearrangeString(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();
        Character prevChar = null;
        int prevFreq = 0;

        // Step 3: Rearrange the string
        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            result.append(currentChar);

            // Decrement the frequency of the current character
            int currentFreq = freqMap.get(currentChar) - 1;
            if (prevChar != null && prevFreq > 0) {
                maxHeap.offer(prevChar);
            }

            // Update the previous character and its frequency
            prevChar = currentChar;
            prevFreq = currentFreq;

            if (currentFreq > 0) {
                freqMap.put(currentChar, currentFreq);
            }
        }

        // Step 4: Check if the rearranged string is valid
        if (result.length() != s.length()) {
            return "Not possible";
        }

        return result.toString();
    }

    public static String rearrangeStringOptimal(String s) {
        int n = s.length();

        // Step 1: Calculate the frequencies of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Step 2: Check for validity
        int maxFreq = 0;
        for (int count : charCount) {
            maxFreq = Math.max(maxFreq, count);
        }
        if (maxFreq > (n + 1) / 2) {
            return "";  // Not possible to rearrange
        }

        // Step 3 and 4: Fill even and odd positions
        char[] result = new char[n];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = n / 2;

        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0 && charCount[i] <= halfLength && oddIndex < n) {
                result[oddIndex] = (char) (i + 'a');
                oddIndex += 2;
                charCount[i]--;
            }
            while (charCount[i] > 0) {
                result[evenIndex] = (char) (i + 'a');
                evenIndex += 2;
                charCount[i]--;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String inputString = "cccbaa";
        String result = rearrangeStringOptimal(inputString);
        System.out.println(result);
    }
}