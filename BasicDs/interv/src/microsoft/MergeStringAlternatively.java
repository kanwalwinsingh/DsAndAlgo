package microsoft;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeStringAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();
        char[] charArray = new char[m+n];
        int i = 0, j =0;
        int k =0;
        while (i<word1.length() && j<word2.length()){
            charArray[k++] = word1.charAt(i++);
            charArray[k++] = word2.charAt(j++);
        }
        while (i<word1.length()){
            charArray[k++] = word1.charAt(i++);
        }
        while (j<word2.length()){
            charArray[k++] = word2.charAt(j++);
        }
        return new String(charArray);
    }
}
