package main.java.binarynumberqueue;

import java.util.Arrays;
import java.util.Collections;

public class MySolut {
    public static void main(String[] args) {
        int[] inputs = {1, 3, 5, 9, 11};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tn: " + inputs[i]);
            System.out.println("\n\tBinary numbers " + Arrays.toString(findBin(inputs[i])));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }

    public static String[] findBin(int n) {
        String[] result = new String[n];
        MyQueue<String> queue = new MyQueue<>();

        // Start with 1 in the queue
        queue.enqueue("1");

        ///loop to generate binary number upto to 'n'

        for (int i = 0; i < n; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";

            // enqueue the new binary back
            queue.enqueue(s1);
            queue.enqueue(s2);

        }
        return result;


    }
}