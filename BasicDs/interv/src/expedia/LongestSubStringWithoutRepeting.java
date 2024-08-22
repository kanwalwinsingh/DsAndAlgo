package expedia;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeting {

    public int lengthOfLongestSubstring(String s) {
        int[] frequency = new int[128];
        int left = 0;
        int maxFrequenccy = 0;
        for (int right = 0; right < s.length(); right++) {
            frequency[s.charAt(right)]++;
            while (frequency[s.charAt(right)] > 1) {
                frequency[s.charAt(left)]--;
                left++;
            }
            maxFrequenccy = Math.max(maxFrequenccy, (right - left) + 1);
        }
        return maxFrequenccy;
    }

    public int lengthOfLongestSubstr(String s){
        int left = 0;
        int right =  0;
        int maxSubstring = 0;
        Set<Character> charSet = new HashSet<>();
        while (right < s.length()){
            char rightChar = s.charAt(right++);
            while (charSet.contains(rightChar)){
                char leftchar = s.charAt(left++);
                charSet.remove(leftchar);
            }
            charSet.add(rightChar);
            maxSubstring = Math.max(maxSubstring,charSet.size());
        }
        return maxSubstring;
    }
        public static void main(String[] args) {
            String s = "aab";
            LongestSubStringWithoutRepeting solution = new LongestSubStringWithoutRepeting();
            int result = solution.lengthOfLongestSubstr(s);

            System.out.println(result); // Output: 3
        }

}
