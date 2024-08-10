package leetcodetop75;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results,new ArrayList<>(),k,n,1);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> combination, int k, int n, int start){
        if(k == 0 && n == 0){
            results.add(new ArrayList<>(combination));
        }
        if(k == 0 || n<0){
            return;
        }
        for(int i = start; i<=9; i++){
            combination.add(i);
            backtrack(results,combination,k-1,n-i,i+1);
            combination.remove(combination.size()-1);
        }
    }
    public static void main(String[] args) {
        CombinationSumThree solution = new CombinationSumThree();

        int k1 = 3;
        int n1 = 7;
        System.out.println("Combinations for k = " + k1 + " and n = " + n1 + ": " + solution.combinationSum3(k1, n1));
        // Expected output: [[1, 2, 4]]

        int k2 = 3;
        int n2 = 9;
        System.out.println("Combinations for k = " + k2 + " and n = " + n2 + ": " + solution.combinationSum3(k2, n2));
        // Expected output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]

        int k3 = 4;
        int n3 = 1;
        System.out.println("Combinations for k = " + k3 + " and n = " + n3 + ": " + solution.combinationSum3(k3, n3));
        // Expected output: []
    }
}
