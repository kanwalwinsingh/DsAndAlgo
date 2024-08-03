package main.java.algorithms.subsetsproblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {
    public static String swapChar(String word, int i, int j){
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i]= swapIndex[j];
        swapIndex[j] = temp;
        return new String(swapIndex);
    }
    public static void permStringRec(String word, int currentIndex, ArrayList<String> results){
        if (currentIndex == word.length()-1){
            results.add(word);
            return;
        }
        for (int index = currentIndex; index <word.length(); index++){
            String swappedStr = swapChar(word,currentIndex,index);
            permStringRec(swappedStr,currentIndex+1,results);
        }
    }
    public static ArrayList<String> permuteWord(String word){
        ArrayList<String> results = new ArrayList<>();
        permStringRec(word,0,results);
        return results;
    }
    public static void main( String args[] ) {
        String[] inputWord = {"ab", "bad", "abcd"};
        for (int index = 0; index < inputWord.length; index++)
        {
            ArrayList <String> permutedWords = permuteWord(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);
            System.out.println(Collections.nCopies(100,"-"));
        }
    }
}
