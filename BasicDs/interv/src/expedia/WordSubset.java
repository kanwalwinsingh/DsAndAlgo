package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubset {
    public List<String> wordSubset(String[] words1, String[] words2) {
        int[] maxFrequecy = new int[26];
        for (String word : words2) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFrequecy[i] = Math.max(maxFrequecy[i], count[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] count = new int[26];
            boolean isUniversal = true;
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] < maxFrequecy[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "oo"};

        WordSubset solution = new WordSubset();
        List<String> result = solution.wordSubset(words1, words2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
