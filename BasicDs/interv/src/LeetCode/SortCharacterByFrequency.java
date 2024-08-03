package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharacterByFrequency {
    public static String frequencySort(String s){
        Map<Character,Integer> charMap = new HashMap<>();
        for(Character c : s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxheap =
                new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> k : charMap.entrySet()){
            maxheap.offer(k);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!maxheap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxheap.poll();
            Character c = entry.getKey();
            int frequency = entry.getValue();
            for (int i =0; i< frequency;i++){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("tree"));

    }
}
