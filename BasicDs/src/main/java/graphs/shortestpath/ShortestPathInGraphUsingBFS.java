package main.java.graphs.shortestpath;

import main.java.graphs.bfs.Queue;
import main.java.graphs.detectcycleingraph.Graph;
import main.java.graphs.detectcycleingraph.LinkedListNode;

import java.util.Arrays;

public class ShortestPathInGraphUsingBFS {
    public static int findMin(Graph g, int src, int dest){
        if(src == dest){
            return 0;
        }
        int result = 0;
        int numVertex = g.vertices;

        // An array to hold the history of visited nodes
        boolean[] visited = new boolean[numVertex];
        //An array for keeping track of distance of current_node from src
        int[] distance = new int[numVertex];

        //Create queue for BFS and enqueue src int it
        Queue<Integer> queue = new Queue<>(numVertex);
        queue.enqueue(src);
        visited[src] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()){
            //Dequeue a node from queue
            int currentNode = queue.dequeue();

            //Visit the neighbour of the dequeued node
            LinkedListNode<Integer> temp = g.adjacencyList[currentNode].head;
            while (temp!=null){
                // mark the neighbour visited and update its distance from src node
                if(!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[currentNode]+1;
                }
                // Return the distance when the dest node is visited
                if(temp.data == dest){
                    return distance[dest];
                }
                temp = temp.next;
            }
        }
        //Return if no path exists btw src and dest
        return -1;
    }
    public static void main(String args[]) {
        Integer[][][] inputs = {
                {{0, 1},{1, 2}},
                {{1, 2},{2, 4},{1, 4},{4, 3}},
                {{0, 1},{1, 2},{2, 3},{3, 4},{2, 4}},
                {{0, 1},{1, 2},{2, 3},{3, 4},{4, 5},{5, 6}},
                {{0, 1},{1, 2}, {2, 3},{0, 3}},
        };

        Integer[] src =  {0, 1, 0, 0, 1};
        Integer[] dest = {2, 3, 4, 6, 3};

        for (int i = 0; i < inputs.length; i++) {
            Graph g = new Graph(7);
            for (int j = 0; j < inputs[i].length; j++){
                g.addEdge(inputs[i][j][0],inputs[i][j][1]);
            }

            String edges="[";
            for (int j = 0; j < inputs[i].length; j++){
                if(j!=inputs[i].length-1)
                    edges=edges+ Arrays.toString(inputs[i][j])+", ";
                else
                    edges=edges+Arrays.toString(inputs[i][j]);




            }
            edges+="]";

            System.out.println("\tEdges: "+edges+"\n");
            g.printGraph();
            System.out.println("\tsrc: "+src[i]);
            System.out.println("\tdest: "+dest[i]);
            System.out.println("\n\tResult: "+findMin(g,src[i],dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
