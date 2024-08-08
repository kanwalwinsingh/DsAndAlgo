package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramIndices {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s == null || p == null || s.length()<p.length()){
            return result;
        }

        //Frequency map for characters in p
        HashMap<Character, Integer> pCount = new HashMap<>();
        for(char c : p.toCharArray()){
            pCount.put(c, pCount.getOrDefault(c,0)+1);
        }

        //Frequency map for sliding window in s
        HashMap<Character, Integer> sCount = new HashMap<>();
        int windowSize = p.length();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            sCount.put(c,sCount.getOrDefault(c,0)+1);

            //Remove the leftmost character from the window
            if(i>=windowSize){
                char leftChar = s.charAt(i-windowSize);
                if(sCount.get(leftChar) == 1){
                    sCount.remove(leftChar);
                }else{
                    sCount.put(leftChar, sCount.get(leftChar) -1);
                }
            }

            //Compare window with p's frequency map
            if(pCount.equals(sCount)){
                result.add(i-windowSize +1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        AnagramIndices solution = new AnagramIndices();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(solution.findAnagrams(s, p)); // Output: [0, 6]

        s = "abab";
        p = "ab";
        System.out.println(solution.findAnagrams(s, p)); // Output: [0, 1, 2]
    }
}
