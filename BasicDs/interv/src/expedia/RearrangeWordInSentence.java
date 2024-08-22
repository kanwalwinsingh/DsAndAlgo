package expedia;

import java.util.Arrays;
import java.util.Comparator;

public class RearrangeWordInSentence {
    public static String arrangeWords(String text) {
        //Step 1: Split the sentence into word
        String[] strArray  = text.split(" ");
      //  Arrays.sort(strArray,(a,b)->a.length() - b.length());

        //Step 2: Sort the words by length
        Arrays.sort(strArray, Comparator.comparingInt(String::length));

        //Step 3: reconstruct the sentence
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(strArray[0].charAt(0))).append(strArray[0].substring(1).toLowerCase());
           for (int i =1; i< strArray.length; i++){
            sb.append(" ").append(strArray[i].toLowerCase());
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is bv cool"));
    }
}
