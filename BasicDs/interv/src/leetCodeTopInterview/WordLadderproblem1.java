package leetCodeTopInterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderproblem1 {
    class Node {
        boolean visited;
        Node[] nodes;
        String str;

        Node(){
            nodes = new Node[26];
        }
    }
    Node root = new Node();

    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<String> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();

        prepareTrie(wordList);
        insert(beginWord,true);

        String str;
        q.offer(beginWord);
        dist.offer(1);
        int d; Node head;
        while (!q.isEmpty()){
            str = q.poll();
            d = dist.poll();
            head = root;
            for(int i =0; i<str.length();i++){
                if(isValid(head,str,endWord,i,q,dist,d))
                    return d+1;
                head = head.nodes[str.charAt(i)-'a'];
            }
        }
        return 0;
    }

    private boolean isValid(Node head, String word, String endWord, int k, Queue<String> q, Queue<Integer> dist, int d){
        int ind = word.charAt(k)-'a', i,ch;
        Node tmp;
        for(int j = 0; j <26; j++){
            i = k+1; tmp = head;
            if(ind != j && head.nodes[j] != null){
                head = head.nodes[j];
                while (i<word.length()){
                    ch = word.charAt(i) - 'a';
                    if(head.nodes[ch] == null) break;
                    head = head.nodes[ch];
                    i++;
                }
                if(i == word.length() && !head.visited){
                    head.visited = true;
                    if(head.str.equals(endWord)) return true;
                    q.offer(head.str);
                    dist.offer(d+1);
                }
            }
            head = tmp;
        }
        return false;
    }

    private void prepareTrie(List<String> words){
        for(String word : words){
            insert(word,false);
        }
    }

    private void insert(String word, boolean b){
        Node head = root; int ind;
        for(int i =0; i<word.length(); i++){
            ind = word.charAt(i)-'a';
            if(head.nodes[ind] == null){
                head.nodes[ind] = new Node();
            }
            head = head.nodes[ind];
        }
        head.str = word;
        head.visited = b;
    }

    public static void main(String[] args) {
        WordLadderproblem1 solution = new WordLadderproblem1();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("Length of shortest transformation sequence: " + solution.ladderLength(beginWord, endWord, wordList));  // Output: 5
    }
}
