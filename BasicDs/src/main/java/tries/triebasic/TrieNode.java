package main.java.tries.triebasic;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEndWord; // will be true if the node reprsent the end of word
    static final int ALPHABET_SIZE = 26;
    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    //Function to mark the currentNode as Leaf
    public void markAsLeaf(){
        this.isEndWord = true;
    }

    //Function to unMark the currentNode as Leaf
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }
}