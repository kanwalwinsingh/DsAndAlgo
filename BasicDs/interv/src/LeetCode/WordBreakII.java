package LeetCode;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word: wordDict){
            trie.insert(word);
        }
        Map<Integer,List<String> > memo = new HashMap<>();
        return wordBreakHelper(s,trie.root,0,memo);
    }

    private List<String> wordBreakHelper(String s, Trie.TrieNode root, int start, Map<Integer, List<String>> memo){
        if(memo.containsKey(start)){
            return memo.get(start);
        }

        List<String> results = new ArrayList<>();
        if(start == s.length()){
            results.add("");
            return results;
        }

        Trie.TrieNode node = root;
        for(int i =start; i<s.length(); i++){
            int charValue = s.charAt(i)-'a';
            if(node.children[charValue] == null){
                break;
            }
            node = node.children[charValue];
            if(node.isEndOfWord){
                List<String> subList = wordBreakHelper(s,root,i+1,memo);
                for(String sub: subList){
                    results.add(s.substring(start,i+1) +(sub.isEmpty() ? "" : " ")+sub);
                }
            }
        }
        memo.put(start,results);
        return results;
    }


    public List<String> wordBreakOptimized(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backTrack(s,wordSet,new StringBuilder(),result,0);
        return result;
    }

    void backTrack(String s, Set<String> wordSet, StringBuilder currSentence, List<String> res, int index){
        if (index == s.length()){
            res.add(currSentence.toString().trim());
        }
        for(int endIndex = index+1; endIndex<=s.length(); endIndex++){
            String word = s.substring(index,endIndex);
            if(wordSet.contains(word)){
                int currentLength = currSentence.length();
                currSentence.append(word).append(" ");
                backTrack(s,wordSet,currSentence,res,endIndex);
                currSentence.setLength(currentLength);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wb = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        System.out.println(wb.wordBreakOptimized(s, wordDict)); // Output: [cats and dog, cat sand dog]

        s = "pineapplepenapple";
        wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wb.wordBreakOptimized(s, wordDict)); // Output: [pine apple pen apple, pineapple pen apple, pine applepen apple]

         s = "cbca";
        wordDict = List.of("bc", "ca");
        System.out.println(wb.wordBreakOptimized(s, wordDict)); // Output: []
    }
}
