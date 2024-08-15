package leetcodetop75;

import java.util.HashSet;
import java.util.Set;

public class MaximumNoOfVowelsInSubStringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> characterSet = new HashSet<>();
        characterSet.add('a');
        characterSet.add('e');
        characterSet.add('i');
        characterSet.add('o');
        characterSet.add('u');
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int maxSum = 0;
        for(int i =0; i< k; i++){
            if(characterSet.contains(charArray[i])){
                maxSum++;
            }
        }
        int currentSum = maxSum;
        for(int i = k; i<n; i++){
            boolean newCharIsVowel = characterSet.contains(charArray[i]);
            boolean oldCharIsVowel = characterSet.contains(charArray[i-k]);
            if((newCharIsVowel && oldCharIsVowel) || (!oldCharIsVowel && !newCharIsVowel)){
                continue;
            }else if(!newCharIsVowel && oldCharIsVowel){
                currentSum--;
            } else if (!oldCharIsVowel && newCharIsVowel) {
                currentSum++;
            }
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowelsOptimal(String s, int k){
        int maxVowels = 0;
        int currentVowels = 0;
        for(int i = 0; i<k; i++){
            if(isVowel(s.charAt(i))){
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        //Step 2: slide the window across the string
        for(int i = k; i < s.length(); i++){
            //Remove the leftmost character of the previous window
            if(isVowel(s.charAt(i-k))){
                currentVowels--;
            }
            //Add the new rightmost nummber of vowels found
            if(isVowel(s.charAt(i))){
                currentVowels++;}
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }


}
