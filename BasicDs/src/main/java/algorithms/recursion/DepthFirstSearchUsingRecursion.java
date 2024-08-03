package main.java.algorithms.recursion;

import main.java.graphs.dfz.DepthFirstSearch;


import java.util.ArrayList;
import java.util.LinkedList;

public class DepthFirstSearchUsingRecursion {
    int numOfVerices;
    LinkedList<Integer>[] tempList;

    DepthFirstSearchUsingRecursion(int numOfVerices){
        this.numOfVerices = numOfVerices;
        tempList = new LinkedList[numOfVerices];
        for (int i =0; i< numOfVerices; i++){
            tempList[i] = new LinkedList<>();
        }
    }

    public void DFSRecursion(int startVertex){
        boolean[] visitedArr = new boolean[numOfVerices];
        dfs(startVertex,visitedArr);
    }

    public void dfs(int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start+" ");

        for (int i =0; i < tempList[start].size();i++){
            int toNode = tempList[start].get(i);
            if(!visited[toNode]){
                dfs(toNode,visited);
            }
        }
    }
    //Method to add an edge between 2 nodes in the graph
    public void addEdge(int fromNode, int toNode){
        tempList[fromNode].addFirst(toNode);
    }
    public static void main( String args[] ) {
        System.out.println( "Your DFS path is: " );

        int nVertices = 6;

        DepthFirstSearchUsingRecursion g = new DepthFirstSearchUsingRecursion(nVertices);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        // Root node given as argument to the function
        g.DFSRecursion(0);
    }


}
