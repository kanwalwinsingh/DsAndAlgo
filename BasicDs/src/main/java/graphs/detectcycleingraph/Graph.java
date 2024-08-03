package main.java.graphs.detectcycleingraph;

public class Graph {

    //Total number of vertices in graph
   public int vertices;

    //An array of linked lists to store adjacent vertices
   public LinkedList< Integer > adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList < > ();
        }
    }


    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);

            //for undirected graph uncomment the line below
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }
    public void printGraph() {
        System.out.println("\tAdjacency List of Directed Graph");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("\t|" + i + "| => ");

                LinkedListNode < Integer > temp = adjacencyList[i].head;
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }
}