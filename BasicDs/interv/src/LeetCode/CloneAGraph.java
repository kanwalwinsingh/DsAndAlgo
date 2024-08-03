package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneAGraph {
    private Map<Node, Node> cloneMap = new HashMap<>();
    private Map<Integer,Node> cloneIntmap = new HashMap<>();
    public Node cloneGraph(Node node){
        if(node == null) return null;

        //Start DFS to clone the graph
        return dfs(node);
    }

    private Node dfs(Node node){
        //If node is already cloned return the clone
        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }

        //Clone the current node
        Node cloneNode = new Node(node.val);
        cloneMap.put(node,cloneNode);

        //Clone all the neighbours
        for (Node neighbour : node.neighbors){
            cloneNode.neighbors.add(dfs(neighbour));
        }
        return cloneNode;
    }
    public Node cloneGraphOptimized(Node node){
        Node newNode;
        if(node!=null){
            if(!cloneIntmap.containsKey(node.val)){
                newNode = new Node(node.val);
                cloneIntmap.put(node.val,newNode);
                for(Node n: node.neighbors){
                    newNode.neighbors.add(cloneGraphOptimized(n));
                }
            }else {
                newNode = cloneIntmap.get(node.val);
            }
            return newNode;
        }else{
            return null;
        }
    }
    public static void main(String[] args) {
        // Create nodes
        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(4);

        // Set up neighbors
        nodeA.neighbors.add(nodeB);
        nodeA.neighbors.add(nodeC);
        nodeB.neighbors.add(nodeA);
        nodeB.neighbors.add(nodeD);
        nodeC.neighbors.add(nodeA);
        nodeC.neighbors.add(nodeD);
        nodeD.neighbors.add(nodeB);
        nodeD.neighbors.add(nodeC);

        // Print the cloned graph to verify
        printGraph(nodeA, new HashSet<>());
        System.out.println("Now the cloned graph ::");

        // Clone the graph
        CloneAGraph graphClone = new CloneAGraph();
        Node clonedGraph = graphClone.cloneGraphOptimized(nodeA);

        // Print the cloned graph to verify
        printGraph(clonedGraph, new HashSet<>());
    }

    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.print("Node " + node.val + " -> Neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}
