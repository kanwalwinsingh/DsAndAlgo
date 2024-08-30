package expedia;

import java.util.*;
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length <2){
            return res;
        }

        // Map to store the reverse of words
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i< words.length; i++){
            map.put(new StringBuilder(words[i]).reverse().toString(),i);
        }

        //Check each word in the array
        for(int i = 0; i<words.length; i++){
            String currentWord = words[i];

            //Check all possible split
            for(int j = 0; j< currentWord.length(); j++){
                String left = currentWord.substring(0,j);
                String right = currentWord.substring(j);

                // case 1: if left part is palindrome, find reverse of right part
                if(isPalindrome(left) && map.containsKey(right) && map.get(right) != i){
                    res.add(Arrays.asList(map.get(right),i));
                }

                if (isPalindrome(right) && map.containsKey(left) && map.get(left) != i && j != currentWord.length()){
                    res.add(Arrays.asList(i,map.get(left)));
                }
            }
        }
        return res;
    }

    //helper function to check if a string is a palindrome
    private boolean isPalindrome(String s){
        int left = 0; int right = s.length()-1;
        while (left < right){
            if (s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();

        String[] words = {"bat", "tab", "cat"};
        System.out.println(pp.palindromePairs(words)); // Output: [[0, 1], [1, 0]]

        words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(pp.palindromePairs(words)); // Output: [[0, 1], [1, 0], [3, 2], [2, 4]]
    }
}
