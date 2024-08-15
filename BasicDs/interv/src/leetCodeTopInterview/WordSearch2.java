package leetCodeTopInterview;

import Gaana.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearch2 {
    class  TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store the word at the end of the string
    }

        public void insertWord(TrieNode root, String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                int index = c-'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // Mark the end of a word

        }

    public List<String> findWords(char[][]board, String[] words){
        List<String> result = new ArrayList<>();

        //Build the trie
        TrieNode root = new TrieNode();
        for(String word : words){
            insertWord(root,word);
        }

        //Iterate through the board
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(board, i , j, root, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){
        char c = board[i][j];
        if(c == '#' || node.children[c-'a'] == null){
            return;
        }

        node = node.children[c-'a'];
        if(node.word != null){
            //Found a word
            result.add(node.word);
            node.word = null; // To avoid duplicates
        }
        board[i][j] = '#'; // Mark the cell as visited
        if(i>0) dfs(board, i-1,j,node,result); // up
        if(j>0) dfs(board, i, j-1, node, result); // left
        if(i<board.length-1) dfs(board, i+1, j, node, result); //Down
        if(j<board[0].length-1) dfs(board, i, j+1, node, result); //Result
        board[i][j] = c;

        //Optimazitaion: Prune the Trie node if it has no children
        if(isEmpty(node)){
            node = null;
        }
    }

    private boolean isEmpty(TrieNode node){
        for(TrieNode child : node.children){
            if(child != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordSearch2 sol = new WordSearch2();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        System.out.println(sol.findWords(board, words));  // Output: ["oath", "eat"]
    }
}
