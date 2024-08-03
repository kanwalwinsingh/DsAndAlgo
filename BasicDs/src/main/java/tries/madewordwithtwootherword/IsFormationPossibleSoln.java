package main.java.tries.madewordwithtwootherword;

import main.java.tries.triebasic.Trie;

public class IsFormationPossibleSoln {
    public static boolean isFormationPossible(String[] dictionary, String word) {
        if (word.length() < 2 || dictionary.length < 2) {
            return false;
        }
        //Create a trie and insert dictinoary element in it
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }
        for (int i = 0; i < word.length(); i++) {
            //Slice the word into two strings in each iteration
            String first = word.substring(0, i);
            String second = word.substring(i,word.length());

            //If both substring present in the trie, the condition is fulfilled
            if (trie.search(first) && trie.search(second)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        String[][] inputs = {
                {"he","hello","home","work"},
                {"play","plot","bat"},
                {"p","q","r"},
                {"abc","def"},
                {"add","addi","number"}
        };

        String[] words={"hehome", "world", "pr", "abcdef", "subtract"};
        int i=0;
        for (String[] input: inputs) {
            String dictionary="[";
            for (int j = 0; j < input.length; j++){
                if(j!=input.length-1)
                    dictionary=dictionary+input[j]+", ";
                else
                    dictionary=dictionary+input[j];




            }
            dictionary+="]";

            System.out.println("\tDictionary: " + dictionary);
            System.out.println("\tword: " +words[i] );
            boolean result = isFormationPossible(input,words[i]);
            System.out.println("\n\tResult: " +result );
            System.out.println(new String(new char[75]).replace('\0', '-'));
            i+=1;



        }




    }
}
