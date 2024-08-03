package main.java.algorithms.unionsetproblems.reduntantconnection;

public class UnionFind {
    public int[] parent;
    public int[] rank;

    //
    public UnionFind(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i =0; i<= n; i++){
            parent[i] = i;
            rank[i] = i;
        }
    }

    //FFunction to find which subset a particular element belong to
    //Return false if both vertices have the same parent, otherwise, updates the parent and rank list by making a connection based on the passed edge
    //Return true if no cycle exist in the graph
    public int find(int v){
        if(parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    //Function to join two subsets into a single subset
    public boolean union(int v1, int v2){
        //Fond the root parent of v1 and v2
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2){
            return false;
        }
        //Updates the parent and rank list otherwise
        else if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

}
