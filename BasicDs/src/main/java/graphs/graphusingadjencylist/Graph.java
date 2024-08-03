package main.java.graphs.graphusingadjencylist;

import main.java.doublelinkedlist.DoublyLinkedList;

public class Graph {
    int vertices; // Total number of vertices in graph
    DoublyLinkedList<Integer> adjanceyList[]; //An array of linked list to store adjacent vertices;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjanceyList = new DoublyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjanceyList[i] = new DoublyLinkedList<>();
        }
    }


   public void printGraph() {
        System.out.println(">>Adjacency List of Directed graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjanceyList[i] != null) {
                System.out.print("|" + i + "| =>|");
                DoublyLinkedList<Integer>.Node temp = adjanceyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] ->");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| => " + "null");
            }
        }
    }// Prints graph

   public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjanceyList[source].insertAtEnd(destination);

            //For undirected graph uncomment this line
            //this.adjanceyList[destination].insertAtEnd(source);
        }
    } //Adds an edge from source vertex to destination vertex


}
