package main.java.tries.sortarrayofwordsusingtire;

import main.java.tries.triebasic.Trie;
import main.java.tries.triebasic.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayOfWordUsingTrie {
    //Recursive function to generate all words in Alphabetical order
    public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] word) {
        //Leaf denotes end of word
        if (root.isEndWord) {
            StringBuilder temp = new StringBuilder();
            for (int x = 0; x < level; x++) {
                temp.append(word[x]);
            }
            result.add(temp.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Non-null child, so add that index to the character array
                word[level] = (char) (i + 'a');
                getWords(root.children[i], result, level + 1, word);
            }
        }
    }

    public static ArrayList<String> sortArray(Trie trie) {
        ArrayList<String> result = new ArrayList<>();
        char[] word = new char[20];
        getWords(trie.root, result, 0, word);
        return result;
    }

    public static void main(String[] args) {
        String[][] keys = {
                {"gram", "grammar", "grain", "grainy", "grape"},
                {"absent", "absorb", "abstain", "abstract", "absurd"},
                {"dormant", "dormitory", "dormouse", "dormant", "dormant"},
                {"prey", "preach", "prepare", "prestige", "prestigious"},
                {"moon", "moose", "mood", "moot", "moor"}
        };

        for (String[] words : keys) {
            System.out.println("Input: " + Arrays.toString(words));
            Trie t = new Trie();
            for (String word : words) {
                System.out.println("Insert: '" + word + "'");
                t.insert(word);
            }

            ArrayList<String> result = sortArray(t);
            System.out.println("\nOutput: " + result + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
