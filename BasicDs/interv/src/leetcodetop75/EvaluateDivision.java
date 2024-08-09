package leetcodetop75;

import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=leetcode-75
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Graph to store each variable and its related variable with coresponding division values
        Map<String, Map<String,Double>> graph = new HashMap<>();

        //Build the graph from the equation
        for(int i =0; i< equations.size(); i++){
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B,value);
            graph.get(B).put(A,1.0/value);
        }

        //Process each query and compute the result using DFS
        double[] results = new double[queries.size()];
        for(int i =0; i<queries.size(); i++){
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            if(!graph.containsKey(C) || !graph.containsKey(D)){
                results[i] = -1.0;
            }else{
                results[i] = dfs(graph,C,D, new HashSet<>(),1.0);
            }
        }
        return results;
    }

    //Dfs helper function to calculate the division along a path
    private double dfs(Map<String,Map<String,Double>> graph, String current, String target, Set<String> visited, double currentProduct){
        //If the current node is the target node, return the accumlated product
        if(current.equals(target)){
            return currentProduct;
        }
        //Mark the current node as visited to avoid cycle
        visited.add(current);

        //Explore neighbours
        Map<String,Double> neighbours = graph.get(current);
        for(String neighbor : neighbours.keySet()){
            if(!visited.contains(neighbor)){
                double result = dfs(graph, neighbor, target, visited, currentProduct* neighbours.get(neighbor));
                if(result != -1.0){
                    return result;
                }
            }
        }

        //Backtrack and return -1.0 if no valid path is found
        visited.remove(current);
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Expected output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
