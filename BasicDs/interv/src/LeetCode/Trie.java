package LeetCode;

import java.util.Map;

public class Trie {
//    public String longestCommonPrefix() {
//        TrieNode node = root;
//        StringBuilder prefix = new StringBuilder();
//        while (node!= null && !node.isEndOfWord && node.getChildrenCount() == 1){
//            for(Map.Entry<Cha>)
//        }
  //  }



    public class TrieNode {
       public TrieNode[] children;
       public boolean isEndOfWord;

       public TrieNode(){
           children = new TrieNode[26];
           isEndOfWord = false;
       }
        public int getChildrenCount(){
            int count = 0;
            for(int i =0; i<26;i++){
                if(root.children[i] != null){
                    count++;
                }
            }
            return count;
        }

   }


   public TrieNode root;

   public Trie(){
       root = new TrieNode();
   }
   public void insert(String word){
       TrieNode node = root;
       for(char c : word.toCharArray()){
           int charval = c-'a';
           if(node.children[charval] == null){
               node.children[charval] = new TrieNode();
           }
           node = node.children[charval];
       }
       node.isEndOfWord = true;
   }

   public boolean search(String word){
       TrieNode node = root;
       for(char ch : word.toCharArray()){
           int chValue = ch - 'a';
           if(node.children[chValue]== null){
               return false;
           }else {
               node = node.children[chValue];
           }
       }
       return node.isEndOfWord;
   }

   public boolean startsWith(String word){
       TrieNode node = root;
       for(char ch : word.toCharArray()){
           int chValue = ch-'a';
           if(node.children[chValue] == null){
               return false;
           }
           node = node.children[chValue];
       }
       return true;
   }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Returns true
        System.out.println(trie.search("app"));     // Returns false
        System.out.println(trie.startsWith("app")); // Returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // Returns true
    }
}
