package leetCodeTopInterview;

import java.util.*;

public class TopologicalSort {
    public List<Character> topologicalSort(Map<Character,List<Character>> graph){
        Map<Character, Integer> inDegree = new HashMap<>();
        List<Character> topOrder = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();

        //Step 1 : Initialize the in-degree of each node
        for(char node : graph.keySet()){
            inDegree.putIfAbsent(node,0);
            for(char neighbor : graph.get(node)){
                inDegree.put(neighbor,inDegree.getOrDefault(neighbor,0)+1);
            }
        }

        //Step 2: Find the nodes with zero in-degree and add them to the queue
        for(char node: inDegree.keySet()){
            if(inDegree.get(node) == 0){
                queue.offer(node);
            }
        }

        //Step 3: Process the nodes in the queue
        while (!queue.isEmpty()) {
            char current = queue.poll();
            topOrder.add(current);


            //Decrease the in-degree of neighbors
            for (char neighbor : graph.get(current)){
                inDegree.put(neighbor,inDegree.get(neighbor) -1);
                if(inDegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4 : Check if topological order includes all nodes
        if(topOrder.size() < graph.size()){
            throw new IllegalArgumentException("Graph contains a cycle topological sort not possible");
        }
        return topOrder;
    }
    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();

        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('w', Arrays.asList('e'));
        graph.put('e', Arrays.asList('r'));
        graph.put('r', Arrays.asList('t'));
        graph.put('t', Arrays.asList('f'));
        graph.put('f', new ArrayList<>());

        List<Character> order = ts.topologicalSort(graph);
        System.out.println("Topological Order: " + order);
    }
}
