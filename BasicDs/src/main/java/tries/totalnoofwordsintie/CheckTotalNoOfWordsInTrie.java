package main.java.tries.totalnoofwordsintie;

import main.java.tries.triebasic.Trie;
import main.java.tries.triebasic.TrieNode;

public class CheckTotalNoOfWordsInTrie {
    public static int totalWords(TrieNode root){
        int result = 0;
        //Leaf denotes the end of word
        if(root.isEndWord){
            result++;
        }
        for(int i =0; i<26; i++){
            if(root.children[i]!= null){
                result+= totalWords(root.children[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[][] words = {
                {"hello", "world", "python", "programming"},
                {"app", "apple", "applepie"},
                {"dog", "dig", "ham", "hamster", "dino"},
                {"sun", "burn"},
                {"red", "blue", "green", "yellow", "orange", "purple"}
        };

        for (String[] wordList: words) {
            Trie t = new Trie();
            int totalWordsFound = 0; // Initialize totalWordsFound counter
            for (String w: wordList) {
                System.out.println("Insert word: '" + w + "'");
                t.insert(w);
            }
            int total = totalWords(t.root);
            System.out.println("\nTotal words found: " + total);

            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }

}
