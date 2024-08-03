package main.java.graphs.dfz;

import main.java.graphs.bfs.EduLinkedList;
import main.java.graphs.bfs.Graph;
import main.java.queueusingtwostacks.MyStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    public static List<Integer> dfsTraversal(Graph graph, int source) {
        List<Integer> result = new ArrayList<>();
        int numVertices = graph.vertices;
        boolean[] visited = new boolean[numVertices];

        //Create a stack for DFS
        MyStack<Integer> stack = new MyStack<>(numVertices);

        //Push the source vertex and mark it as visited
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            result.add(currentVertex);
            EduLinkedList<Integer>.Node temp = graph.adjacencyList[source].headNode;
            while (temp != null) {
                int neighbour = temp.data;
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
                temp = temp.nextNode;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] graph_vertices = {5, 4, 6};
        int[][][][] graph_edges = {
                {{{0, 1, 2}, {2, 0, 3, 4}}},
                {{{0, 1, 2}, {2, 0, 3}}},
                {{{0, 1, 4}, {1, 2, 5}, {4, 3}, {3, 2}}}
        };
        int[] sources = {2, 0, 0};

        for (int i = 0; i < graph_vertices.length; i++) {
            Graph graph = new Graph(graph_vertices[i]);
            for (int j = 0; j < graph_edges[i][0].length; j++) {
                int source = graph_edges[i][0][j][0];
                for (int k = 1; k < graph_edges[i][0][j].length; k++) {
                    int destination = graph_edges[i][0][j][k];
                    graph.addEdge(source, destination);
                }
            }
            System.out.println((i + 1) + ".\tAdjacency List of the Graph\n");
            graph.printGraph();
            System.out.println("\n\tDFS Traversal starting from vertex " + sources[i] + ": " + dfsTraversal(graph, sources[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }
}
