package main.java.algorithms.triealgos.searchsuggestion;

import java.util.LinkedList;


public class Node {
    Node[] child = new Node[26];
    LinkedList<String> searchWords = new LinkedList<>();
}
