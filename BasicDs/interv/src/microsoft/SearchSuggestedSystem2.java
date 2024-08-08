package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestedSystem2 {
    class TrieNode {
        public TrieNode[] children;
        public boolean isEndOfWord;
        public PriorityQueue<String> suggestions;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
            suggestions = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addSuggestion(String product) {
            suggestions.offer(product);
            if (suggestions.size() > 3) {
                suggestions.poll();
            }
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String product) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.addSuggestion(product);
            }
            node.isEndOfWord = true;
        }

        public List<String> getSuggestions(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return new ArrayList<>(); // No suggestions
                }
                node = node.children[index];
            }
            List<String> result = new ArrayList<>(node.suggestions);
            return result;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        //Insert all product into the trie
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getSuggestions(prefix));
        }
        return result;
    }

    public static void main(String[] args) {
        SearchSuggestedSystem2 system = new SearchSuggestedSystem2();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = system.suggestedProducts(products, searchWord);

        // Output the result
        for (List<String> suggestions : result) {
            System.out.println(suggestions);
        }
    }
}
