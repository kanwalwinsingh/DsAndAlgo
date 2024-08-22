package agoda;

import java.util.*;

/**
 * The given problem involves taking a string s and an integer k. The task is to rearrange the characters of the string in such a way that the same characters in the new string are separated by at least k distances from each other. If it is not possible to perform such a rearrangement that satisfies the condition, the output should be an empty string "".
 *
 * For example, If we have the string s = "aabbcc" and k = 3, one possible rearrangement could be "abcabc", as any same characters are at least k = 3 units apart. However, if k was larger, say 7, it would be impossible to rearrange because we don't have enough unique characters to place between repeats to satisfy the distance requirement.
 */
public class RearrangeString {

    public static String rearrangeString(String s, int k){
        // Length of the input string
        int stringLength = s.length();

        //Array to keep track of the character count
        int[] charCount = new int[26];

        //Count the frequency of each character in the string
        for(char ch : s.toCharArray()){
            ++charCount[ch-'A'];
        }

        //Priority queue to store character frequencies and sort them in desceding order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0] -a[0]);

        //Add  character counts to the priority queue
        for(int i = 0; i< 26; i++){
            if(charCount[i] > 0){
                maxHeap.offer(new int[] {charCount[i], i});
            }
        }

        //Queue to keep track of characters used in the last k position
        Deque<int[]> queue = new ArrayDeque<>();

        //String builder to build the result
        StringBuilder result = new StringBuilder();
        //Loop until the priority queue is empty
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // Get the most frequent remaining character
            int count = current[0];
            int charIndex = current[1];

            //Add the character to the result
            result.append((char) ('A' + charIndex));
            i++;
            //Decrease the count and add character to the queue
            queue.offer(new int[]{count - 1, charIndex});

//            if(maxHeap.isEmpty() && i<k+1) {
//                while (i != k){
//                    result.append('#');
//                    i++;
//                }
//                i = 0;
//            }

            // if there are k elements in queue, its time to release the front elements
            if (queue.size() >= k) {
                int[] front = queue.pollFirst();
                if (front[0] > 0) {
                    //If it still has remaining count, add it back to the priorpty queue
                    maxHeap.offer(front);
                }
            }
        }

            // Check if the result string's length is same as the input string
            // If not, return empty string as it's not possible to rearrange
            return result.length() == stringLength ? result.toString() : "";
    }

    public static void main(String[] args) {
        String s1 = "AAABBB";
        int width1 = 2;
        System.out.println(rearrangeString(s1, width1)); // Example output: "AB#AB#AB#"

        String s2 = "AAA";
        int width2 = 3;
        System.out.println(rearrangeString(s2, width2)); // Example output: "A##A##A##"

        String s3 = "aabbc";
        int width3 = 2;
        System.out.println(rearrangeString(s3.toUpperCase(), width3)); // Example output: "AB#ABC"
    }
}

