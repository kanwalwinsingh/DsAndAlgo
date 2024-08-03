package LeetCode;

import java.util.List;

public class WordBreak {

    /**
     * https://leetcode.com/problems/word-break/description/
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word : wordDict){
            trie.insert(word);
        }
        return wordBreakHelper(s, trie.root, 0,new Boolean[s.length()]);

    }
    private boolean wordBreakHelper(String s, Trie.TrieNode root, int start, Boolean[] memo){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        Trie.TrieNode node = root;
        for(int i =start; i<s.length();i++){
            int charValue = s.charAt(i)-'a';
            if(node.children[charValue] == null){
                memo[start] = false;
                return false;
            }
            node = node.children[charValue];
            if(node.isEndOfWord && wordBreakHelper(s,root,i+1,memo)){
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wb.wordBreak(s, wordDict)); // Output: true

        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        System.out.println(wb.wordBreak(s, wordDict)); // Output: true

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wb.wordBreak(s, wordDict)); // Output: false
    }
}
