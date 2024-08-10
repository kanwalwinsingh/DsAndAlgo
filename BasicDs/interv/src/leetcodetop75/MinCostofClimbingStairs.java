package leetcodetop75;

public class MinCostofClimbingStairs {
    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        //Base case
        if(n == 1) return cost[0];
        if(n == 2) return Math.min(cost[0],cost[1]);

        //Creates a dp array to store the minimum cost to reach each step
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        //Fill the dp array
        for(int  i = 2; i<n; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }

        //The result is the minimum cost to reach the last step or the step before the last one
        return Math.min(dp[n-1],dp[n-2]);
    }
    // Driver code to test the solution
    public static void main(String[] args) {
        MinCostofClimbingStairs solution = new MinCostofClimbingStairs();

//        int[] cost1 = {10, 15, 20};
//        System.out.println("Minimum cost for cost = [10, 15, 20]: " + solution.minCostClimbingStairs(cost1));
//        // Expected output: 15 (Start at 0, go to 1, then 2)

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost for cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]: " + solution.minCostClimbingStairs(cost2));
        // Expected output: 6 (Start at 0, go to 2, then 4, then 6, then 8)
    }
}
