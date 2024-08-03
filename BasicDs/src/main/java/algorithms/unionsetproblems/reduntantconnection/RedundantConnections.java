package main.java.algorithms.unionsetproblems.reduntantconnection;

import java.util.Arrays;

public class RedundantConnections {
    public static int[] redundantConnection(int[][] edges){
        UnionFind connections = new UnionFind(edges.length);
        for (int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];
            if(!connections.union(v1,v2)){
                return edge;
            }
        }
        return new int[]{};
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 2}, {1, 3}, {2, 3}},
                {{1, 2}, {2, 3}, {1, 3}},
                {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}},
                {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {2, 4}},
                {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}}
        };

        for (int i = 0; i < edges.length; i++) {
            System.out.println((i + 1) + ".\tEdges: " + Arrays.deepToString(edges[i]));
            System.out.println("\n\tThe redundant connection in the graph is: " + Arrays.toString(redundantConnection(edges[i])));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
