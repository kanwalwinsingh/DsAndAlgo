package leetcodetop75;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class RearrangeRoadsOfCitytoReachZeroCity
{
    public int minReorder(int n, int[][] connections) {
        //Create an adjaceny list to store the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //Fill the graph, storing both directions of each road
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); //road in original direction
            graph.get(conn[1]).add(new int[]{conn[0], 0}); //road in reverse direction
        }
        //Perform DFS starting from the capital city 0
        return dfs(0, -1, graph);
    }

   private int dfs(int node, int parent, List<List<int[]>> graph){
        int reorientations = 0;
        for(int[] neighbour : graph.get(node)){
            int nextCity = neighbour[0];
            int needsReorientation = neighbour[1];

            //Avoid moving back to the parent node
            if(nextCity == parent) continue;

            //Count reorientation if the road is in the original direction
            reorientations += needsReorientation;

            //Recursively check the next city
            reorientations +=dfs(nextCity, node, graph);
        }
        return reorientations;

   }

    public static void main(String[] args) {
        RearrangeRoadsOfCitytoReachZeroCity solution = new RearrangeRoadsOfCitytoReachZeroCity();

        int[][] connections1 = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
        int result1 = solution.minReorder(6, connections1);
        System.out.println("Minimum reorientations for example 1: " + result1); // Expected output: 3

        int[][] connections2 = {{1,0}, {1,2}, {3,2}, {3,4}};
        int result2 = solution.minReorder(5, connections2);
        System.out.println("Minimum reorientations for example 2: " + result2); // Expected output: 2
    }

}
