package Gaana;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    //Each TrieNode contains a map of childern and a flag to mark the end of word
    Map<Character,TrieNode> childern = new HashMap<>();
    boolean isEndOfWord =  false;
}
