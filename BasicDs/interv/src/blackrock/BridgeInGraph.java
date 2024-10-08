package blackrock;

import java.util.Iterator;
import java.util.LinkedList;

public class BridgeInGraph {
    public static class Graph {
        private int V;
        //Array of list for adjacency list reperesentation
        private LinkedList<Integer> adj[];
        int time =0;
        static final int NIL = -1;

        @SuppressWarnings("Unchecked")
        Graph(int v){
            V = v;
            adj = new LinkedList[v];
            for(int i =0; i<v; i++){
                adj[i]  = new LinkedList<>();
            }
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w){
            adj[v].add(w);
            adj[w].add(v);
        }

        /**
         * A recursive function that finds and prints bridges using DFS traversal
         * @param u -> the vertex to be visited next
         * @param visited -> keep track of visited vertices
         * @param disc -> stores discovery time of visited vertices
         * @param low ->
         * @param parent -> store parent vertices in dfs tree
         */
        void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]){
           // mark the current node as visited
            visited[u] = true;

            //Initalize discovery time and low value
            disc[u] = low[u] = ++time;

            //Go through all vertices adjacent to this
            Iterator <Integer> i = adj[u].iterator();
            while (i.hasNext()){
                int v = i.next(); // v is current adjacent of u

                //If v is not visited yet, then make it  child of u in dfs tree and recur for it.
                // if v is not visited yet, then recur for it.
                if(!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);
                    // Check if the subtree rooted with v has a has a connection to one of the ancestor of u
                    low[u] = Math.min(low[u], low[v]);
                    // if the lowest vertex reachable from subtree
                    //under v is below u in DFS tree, then u-v a bridge
                    if (low[v] > disc[u]) {
                        System.out.println(u + " " + v);
                    }
                }
                    //update low value of u for parent function
                    else if ( v != parent[u]){
                        low[u] = Math.min(low[u],disc[v]);

                }
            }

        }

        void bridge(){
            boolean[] visited = new boolean[V];
            int[] disc  = new int[V];
            int[] low  =new int[V];
            int[] parent  =new int[V];

            for(int i =0; i<V; i++){
                parent[i] = NIL;
                visited[i] = false;
            }

            for(int i =0; i<V; i++){
                if (!visited[i]){
                    bridgeUtil(i,visited,disc,low,parent);
                }
            }
         }
    }

    public static void main(String args[]) {
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();

        System.out.println("Bridges in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.bridge();
        System.out.println();

        System.out.println("Bridges in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.bridge();
    }
}
