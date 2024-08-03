package main.java.graphs.pathexists;

import java.util.*;

public class CheckIfPathExistsBtwTwoVertices {
    public static boolean checkPath(int n, int[][] edges, int source, int destination){
        int[][] adjancey = new int[n][n];
        for(int[] edge: edges){
            adjancey[edge[0]][edge[1]] = 1;
            adjancey[edge[1]][edge[0]] = 1;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);
        while (!queue.isEmpty()){
            int currentVertex = queue.poll();

            //Check if the dequeued vertex is the destination
            if(currentVertex == destination){
                return true;
            }

            //Explore neighbour of the current vertex
            for(int i =0; i<n; i++){
                //If neighbour has not been visited yet, enqueue it and mark it as visited
                if(adjancey[currentVertex][i] == 1 && !visited.contains(i)){
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        // Return false if destination vertex is not reached
        return false;
    }

    public static void main(String[] args) {
        int[] n = {3, 4, 6, 5, 7};
        int[][][] edges = {
                {{0, 1}, {1, 2}},
                {{0, 1}, {0, 3}},
                {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {3, 5}},
                {{0, 3}, {1, 3}, {2, 4}},
                {{0, 6}, {1, 5}, {1, 4}, {2, 4}, {2, 5}, {2, 6}, {3, 4}, {3, 6}, {4, 5}, {5, 6}}
        };
        int[] sources = {2, 0, 0, 3, 5};
        int[] destinations = {0, 2, 5, 4, 3};

        for (int i = 0; i < edges.length; i++) {
            System.out.println((i+1) + ".\tn: " + n[i]);
            System.out.println("\tEdges: " + Arrays.deepToString(edges[i]));
            System.out.println("\tSource: " + sources[i]);
            System.out.println("\tDestination: " + destinations[i]);
            System.out.println("\tPath exists: " + checkPath(n[i], edges[i], sources[i], destinations[i]));

            StringBuilder dashes = new StringBuilder();
            for (int k = 0; k < 100; k++) {
                dashes.append("-");
            }
            System.out.println(dashes.toString());
        }
    }
}
