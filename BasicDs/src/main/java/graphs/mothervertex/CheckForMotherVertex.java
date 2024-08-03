package main.java.graphs.mothervertex;


import main.java.graphs.detectcycleingraph.Graph;
import main.java.graphs.detectcycleingraph.LinkedListNode;
import main.java.reversefirstkelementinqueue.MyStack;


import main.java.graphs.detectcycleingraph.LinkedList;

import java.util.Arrays;
import java.util.Stack;

public class CheckForMotherVertex {
    public static int performDFS(Graph g, int source){
        int numOfVertices = g.vertices;
        boolean[] visited = new boolean[numOfVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        visited[source] = true;
        int verticesReached = 1;
        while (!stack.isEmpty()){
            int currentNode = stack.pop();
            LinkedList<Integer> adjanceList = g.adjacencyList[currentNode];
            LinkedListNode<Integer> headNode = adjanceList.head;
            while (headNode!=null){
                if(!visited[headNode.data]){
                    stack.push(headNode.data);
                    visited[headNode.data] = true;
                    verticesReached++;
                }
                headNode = headNode.next;
            }

        }
        return verticesReached;
    }

    public static int findMotherVertex(Graph g){
        int numOfVertices = g.vertices;
        for(int i =0; i<numOfVertices;i++){
            int numofVerticesReached = performDFS(g,i);
            if(numofVerticesReached == numOfVertices){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] n = {3, 4, 5, 4, 3};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{2, 3}, {3, 2, 1}, {3, 0, 2}, {2, 1}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 2, 1}, {3, 2, 1}, {2, 1, 0}},
                {{2, 0, 1}, {1, 2}},
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
            System.out.println("\n\t The mother vertex in this graph is: " + findMotherVertex(g));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
