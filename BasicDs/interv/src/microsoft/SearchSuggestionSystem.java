package microsoft;

import java.util.*;

public class SearchSuggestionSystem {

    class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        PriorityQueue<String> suggestions = new PriorityQueue<>((a,b)->b.compareTo(a));

        public void addSugestion(String product){
                suggestions.offer(product);
                if (suggestions.size() > 3) {
                    suggestions.poll(); // maintain only top3
                }
        }
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String product){
            TrieNode node = root;
            for(char c : product.toCharArray()){
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.addSugestion(product);
            }
        }

        public List<String> getSuggestions(String prefix){
            TrieNode node = root;
            for(char c: prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) {
                    return new ArrayList<>();
                }
            }
                List<String> result = new ArrayList<>(node.suggestions);
            Collections.sort(result);
            return result;
        }
    }

    public List<List<String>> suggestedProduct(String[] products, String searchWord){
        Trie trie = new Trie();
        //Insert all product
        for(String product : products){
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        //Get suggestions for each prefix of searchWord
        for(char c: searchWord.toCharArray()){
            prefix+=c;
            result.add(trie.getSuggestions(prefix));
        }
        return result;
    }
    public static void main(String[] args) {
        SearchSuggestionSystem system = new SearchSuggestionSystem();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = system.suggestedProduct(products, searchWord);

        // Output the result
        for (List<String> suggestions : result) {
            System.out.println(suggestions);
        }
    }
}
