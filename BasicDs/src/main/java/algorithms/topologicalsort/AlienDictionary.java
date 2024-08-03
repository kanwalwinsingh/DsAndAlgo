package main.java.algorithms.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AlienDictionary {
//    public static String alienOrder(List<String> words){
//        HashMap<Character, List<Character>> adjList = new HashMap<>();
//        HashMap<Character, Integer> count = new HashMap<>();
//        for(String word : words){
//            char[] strArray = word.toCharArray();
//            for(char c: strArray){
//                count.put(c,0);
//            }
//        }
//        Set<Character> characters = count.keySet();
//        for(int i =0; i< words.size()-1;i++){
//            String word1 = words.get(i);
//            String word2 = words.get(i+1);
//            intj =0;
//            for(int j =0; j<word1.length() && j<word2.length(); j++) {
//                char c = word1.charAt(j);
//                char d = word2.charAt(j);
//
//                if (c != d) {
//                    adjList.computeIfAbsent(c, k -> new ArrayList<>());
//                    adjList.computeIfAbsent(c, k -> new ArrayList<>());
//                    boolean found = false;
//                    for(int k =0; k<adjList.get(c).size();k++){
//                        if (adjList.get(c).get(k) == d){
//                            found = true;
//                        }
//                    }
//                    if(!found){
//                        adjList.get(c).add(d);
//                        count.put(d,count.get(d)+1);
//                    }
//                    break;
//                }
//            }
//            }
//        }
    }

