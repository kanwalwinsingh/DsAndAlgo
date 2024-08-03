package main.java.graphs.checkifgrapgistree;

import main.java.graphs.detectcycleingraph.Graph;
import main.java.graphs.detectcycleingraph.LinkedListNode;

import java.util.Arrays;

public class CheckIfGraphisTreeSoln {
    public static boolean isTree(Graph graph){
        boolean[] visited = new boolean[graph.vertices];

        //Check cycle by recursively visiting adjacent nodes starting from the first node
        if(checkCycle(graph,0,visited,-1)){
            return false;
        }
        //Check if all nodes are visited from the source
        for(int i =0; i< visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean checkCycle(Graph graph, int node, boolean[] visited, int parent){
        visited[node] = true;

        //Pick adjacent node and run recursive DFS
        LinkedListNode<Integer> adjacent = graph.adjacencyList[node].head;
        while (adjacent!=null){
            if(!visited[adjacent.data]){
                if(checkCycle(graph, adjacent.data, visited,node)){
                    return true;
                }
            }else if (adjacent.data != parent) {
                // Check if previously visited node is parent node
                return true;
            }
            adjacent = adjacent.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n = {3, 4, 5, 5, 6, 1};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}},
                {}
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ".\t n = " + n[i]);
            System.out.println("\t Edges = " + Arrays.deepToString(edges[i]));

            Graph g = new Graph(n[i]);
            for (int j = 0; j < edges[i].length; j++) {
                g.addEdge(edges[i][j][0], edges[i][j][1]);
            }

            System.out.println("\n");
            g.printGraph();
            System.out.println("\n\t Is the given graph a valid tree:" + isTree(g));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
