package Gaana;

public class Trie {
    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    //Insert a word into the trie
    public void insert(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(!current.childern.containsKey(c)){
                current.childern.put(c,new TrieNode());
            }
            current = current.childern.get(c);
        }
        current.isEndOfWord = true;
    }

    //Search for a word in the Trie
    public boolean search(String word){
        TrieNode node = searchNode(word);
        return node != null & node.isEndOfWord;
    }

    //Checks if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix){
        return searchNode(prefix) != null;
    }

    //Helper method to traverse the Trie based on the given word or prefix
    private TrieNode searchNode(String str){
        TrieNode current = root;
        for(char c: str.toCharArray()){
            current = current.childern.get(c);
            if(current == null){
                return null;
            }
        }
        return current;
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
