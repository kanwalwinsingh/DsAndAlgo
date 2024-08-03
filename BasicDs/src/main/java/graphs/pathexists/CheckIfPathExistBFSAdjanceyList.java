package main.java.graphs.pathexists;
// This class represent as a graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckIfPathExistBFSAdjanceyList {
    int V;

    //pointer to an array containing adjancey list
    ArrayList<ArrayList<Integer>> adj;

    CheckIfPathExistBFSAdjanceyList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    //function to add an edge to the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    // A BFS based function to check whether d is reachable from s.
    boolean isReachable(int s, int d) {
        // Base case
        if (s == d) {
            return true;
        }
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        //Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        //Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            //Dequeue a vertex from queue and print it
            int currentElement = queue.poll();

            for (int i = 0; i < adj.get(currentElement).size(); i++) {
                //If this is the adjacent node is the destination node then return true;
                if (adj.get(currentElement).get(i) == d) {
                    return true;
                } else {
                    //Else, continue to do BFS
                    if (!visited[adj.get(currentElement).get(i)]) {
                        visited[adj.get(currentElement).get(i)] = true;
                        queue.add(adj.get(currentElement).get(i));
                    }
                }
            }
        }
        //If BFS is completed without visiting d
        return false;
    }
    public static void main(String[] args)
    {

        // Create a graph given in the above diagram
        CheckIfPathExistBFSAdjanceyList g = new CheckIfPathExistBFSAdjanceyList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1, v = 3;
        if (g.isReachable(u, v))
            System.out.println("\n There is a path from "+u+" to "+v);
        else
            System.out.println("\n There is no path from "+u+" to "+v);

    }
}
