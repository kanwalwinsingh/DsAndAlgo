package main.java.algorithms.unionsetproblems.noofislands;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {
    private List<Integer> parent;
    private List<Integer> rank;
    private int count;

    public UnionFind(List<List<Character>> grid){
        int m = grid.size();
        int n = grid.get(0).size();
        this.parent = new ArrayList<>();
        this.rank = new ArrayList<>();
        count = 0;
        for (int i =0; i< m; i++){
            for (int j =0; j<n; j++){
                if(grid.get(i).get(j) == '1'){
                    this.parent.add(i*n+j);
                    this.count +=1;
                }else{
                    this.parent.add(-1);
                }
                this.rank.add(1);
            }
        }
    }

    public List<Integer> getParent() {
        return this.parent;
    }

    // Function to return the number of connected components consisting of 1s
    public int getCount() {
        return this.count;
    }

    //Function to find parent
    public int find(int v){
        if(this.parent.get(v) != v){
            this.parent.set(v,find(this.parent.get(v)));
        }
        return this.parent.get(v);
    }

    //function to connect component
    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 != p2){
            //The absolute value of root node reprsent the size of this union
            //make the one with larger size be the new parent
            if (this.rank.get(p1) > this.rank.get(p2)){
                this.parent.set(p2,p1);
            }else if(this.rank.get(p2) >this.rank.get(p1)){
                this.parent.set(p1,p2);
            }else{
                this.parent.set(p2,p1);
                this.rank.set(p1, this.rank.get(p1)+1);
            }
            count--;
        }
    }

}
