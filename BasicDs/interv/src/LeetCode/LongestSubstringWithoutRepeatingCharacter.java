package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int left =0, right =0;
        int maxSubstring = 0;
        while (left<s.length() && right<s.length()){
            if(characterSet.contains(charArray[right])){
                characterSet.remove(charArray[left++]);
            }else {
                characterSet.add(charArray[right++]);
                maxSubstring = Math.max(maxSubstring, right - left);
            }
        }
       return maxSubstring;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }


//    HashSet<Character> map = new HashSet<>();
//    int max = 1;
//    int i = 0;
//    int j = 0;
//        if (s.length() == 0) {
//        return 0;
//    }
//        while (j < s.length()) {
//
//        while (map.contains(s.charAt(j))) {
//            map.remove(s.charAt(i));
//            i++;
//        }
//
//        map.add(s.charAt(j));
//        j++;
//        max = Math.max(max, j - i);
//    }
//        return max == 1 ? 1 : max;

}
