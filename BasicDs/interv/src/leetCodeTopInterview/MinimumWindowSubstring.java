package leetCodeTopInterview;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        if(s == null || t == null || s.length()<t.length()){
            return  "";
        }
        //Frequency map for character in t
        Map<Character, Integer> tFeq = new HashMap<>();
        for(char c: t.toCharArray()){
            tFeq.put(c, tFeq.getOrDefault(c,0)+1);
        }

        //Sliding window variables
        Map<Character,Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        int required = tFeq.size();
        while (right<s.length()){
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c,0)+1);

            if(tFeq.containsKey(c) && windowFreq.get(c).equals(tFeq.get(c))){
                formed++;
            }

            while(left <= right && formed == required){
                c = s.charAt(left);

                //Update the result if this window is smaller
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }

                //Contract the window
                windowFreq.put(c,windowFreq.get(c)-1);
                if(tFeq.containsKey(c) && windowFreq.get(c).compareTo(tFeq.get(c)) < 0){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }

    public String minWindowOptimal(String s, String t){
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int start = 0;
        int end = 0;
        int[] freq = new int[128];
        int startIndex = 0;
        int size = Integer.MAX_VALUE;
        int counter = tArr.length;
        for(char x: tArr){
            freq[x]++;
        }
        while (end<sArr.length){
            if(freq[sArr[end++]]-- >0){
                counter--;
            }
            while (counter == 0){
                if(end  - start < size){
                    size = end-start;
                    startIndex = start;
                }
                if(freq[sArr[start++]]++ == 0){
                    counter++;
                }
            }
        }
        return  size == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+size);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + solution.minWindowOptimal(s, t)); // Output: "BANC"
    }
}
