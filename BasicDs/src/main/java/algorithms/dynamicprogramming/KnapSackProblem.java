package main.java.algorithms.dynamicprogramming;

public class KnapSackProblem {
    public static int findMaxKnapsackProfit(int  capacity, int[] weights, int[] values){
        int n= weights.length;
        int[] dp = new int[capacity+1];

        for(int i =0; i<n; i++){
            for (int j = capacity; j>=weights[i]; j--){
                dp[j] =Math.max(values[i] + dp[j-weights[i]],dp[j]);
            }
        }
        return dp[capacity];
    }

    // Driver code
    public static void main(String[] args) {

        int[][] weights = {
                { 1, 2, 3, 5 },
                { 4 },
                { 2 },
                { 3, 6, 10, 7, 2 },
                { 3, 6, 10, 7, 2, 12, 15, 10, 13, 20 }
        };

        int[][] values = {
                { 1, 5, 4, 8 },
                { 2 },
                { 3 },
                { 12, 10, 15, 17, 13 },
                { 12, 10, 15, 17, 13, 12, 30, 15, 18, 20 }
        };

        int[] capacity = { 6, 3, 3, 10, 20 };


        for (int i = 0; i < values.length; ++i) {
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            System.out.println("Weights   |     Values");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = findMaxKnapsackProfit(capacity[i], weights[i], values[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }
}
