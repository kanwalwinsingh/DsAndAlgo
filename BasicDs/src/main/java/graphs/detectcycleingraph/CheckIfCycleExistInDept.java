package main.java.graphs.detectcycleingraph;

public class CheckIfCycleExistInDept {
    public static boolean detectCycle(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        boolean[] recNodeStack = new boolean[g.vertices];
        for (int node = 0; node < g.vertices; node++) {
            if (detectCycleRec(g, node, visited, recNodeStack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleRec(Graph g, int node, boolean[] visited, boolean[] recNodeStack) {
        if (recNodeStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recNodeStack[node] = true;
        LinkedListNode<Integer> headNode = g.adjacencyList[node].head;
        while (headNode != null) {
            int adjacent = headNode.data;
            if (detectCycleRec(g, adjacent, visited, recNodeStack)) {
                return true;
            }
            headNode = headNode.next;
        }
        recNodeStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
            g.printGraph();
            System.out.println("\n\tOutput: " + detectCycle(g));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

