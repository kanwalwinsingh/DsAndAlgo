package LeetCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepetition {
    public static int solution(String s){
        HashSet<Character> map = new HashSet<>();
        int max = 1;
        int i = 0;
        int j = 0;
        if (s.length() == 0) {
            return 0;
        }
        while (j < s.length()) {

            while (map.contains(s.charAt(j))) {
                map.remove(s.charAt(i));
                i++;
            }

            map.add(s.charAt(j));
            j++;
            max = Math.max(max, j - i);
        }
        return max == 1 ? 1 : max;
     }

    public static void main(String[] args) {
        System.out.println(solution("pwwkew"));
    }
}
