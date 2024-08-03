package main.java.tries.findallwordstoredintrie;

import main.java.tries.triebasic.Trie;
import main.java.tries.triebasic.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllWordsStoredInTrie {

    //Recursive function to get the maximum depth of a trie
    public static int getMaxDepth(TrieNode root, int level) {
        //If the root is null, return the current level
        if (root == null) {
            return level;
        }
        int maxDepth = level;
        for (TrieNode child : root.children) {
            if (child != null) {
                //Recursively calcualte the max depth of subtree
                maxDepth = Math.max(maxDepth, getMaxDepth(child, level + 1));
            }
        }
        return maxDepth;
    }

    //Recursive function to find all words stored in a trie
    public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str) {
        //If the current node marks the end of a word, construct the word and append it to the result list
        if (root.isEndWord) {
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Update the word array with the character at the current level
                str[level] = (char) (i + 'a');
                //Recursively explore the child node
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }

    //Helper function to call the getWords function
    public static ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<>();
        int size = getMaxDepth(root, 0);
        char[] chararr = new char[size];
        getWords(root, result, 0, chararr);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        int num = 1;
        String[][] words = {
                {"gram", "groom", "ace", "act", "actor"},
                {"abs", "crow", "crop", "abstain", "crunch"},
                {"dorm", "norm", "prom", "loom", "room"},
                {"prey", "prep", "press", "preps", "prefix"},
                {"moon", "once", "face", "dice", "mole"}
        };

        for (String[] wordList: words) {
            Trie t = new Trie();
            for (String w: wordList) {
                System.out.println("Insert word: '" + w + "'");
                t.insert(w);
                ++num;
            }
            List< String > wordsFound = findWords(t.root);
            System.out.print("\nWords found: [");
            for (String word: wordsFound) {
                System.out.print("'" + word + "' ");
            }
            System.out.print("]\n");

            StringBuilder lineBuilder = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                lineBuilder.append("-");
            }
            String line = lineBuilder.toString();
            System.out.println(line);
        }
    }
}
