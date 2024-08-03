package Gaana.simple.trie;

import Gaana.TrieNode;

public class Trie {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isLeafNode;

        public TrieNode() {
            children = new TrieNode[26];
            isLeafNode = false;
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int charvalue = ch-'a';
            if(current.children[charvalue] == null){
                current.children[charvalue] = new  TrieNode();
            }
            current = current.children[charvalue];
        }
        current.isLeafNode = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int charValue = ch-'a';
            if(current.children[charValue] == null){
                return false;
            }
            current = current.children[charValue];
        }
        return current.isLeafNode;
    }

    public boolean startsWith(String prefix){
        TrieNode current = root;
        for(char ch : prefix.toCharArray()){
            int charvalue = ch-'a';
            if(current.children[charvalue] == null){
                return false;
            }
            current = current.children[charvalue];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
