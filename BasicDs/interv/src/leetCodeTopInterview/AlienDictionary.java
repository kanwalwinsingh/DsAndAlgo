package leetCodeTopInterview;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        //Step 1: Create a graph and in-degree ,
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        //Initialize the graph and in-degree array with unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        //Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid case where prefix is larger in the earlier word
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break; // only the first non-matching character can determine the order
                }
            }
        }

        //Step 3: Topological Sort using BFS (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();

        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        //Step 4 : Check if the order contains all character
        if (order.length() < inDegree.size()) {
            return ""; // There is a cycle, invalid ordering
        }
        return order.toString();
    }

    // Driver code
    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String order = solver.alienOrder(words);
        System.out.println("The order of characters is: " + order);
    }
}
