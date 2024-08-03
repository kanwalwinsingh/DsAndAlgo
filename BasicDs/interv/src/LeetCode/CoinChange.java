package LeetCode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount){
        if (amount == 0) return 0;

        int max = amount+1; //Init with a value larger than any possible solution
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max); // fill dp with max array;
        dp[0] = 0;
        for(int coin : coins){
            for (int i = coin; i<= amount; i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]>amount ? -1: dp[amount];
    }
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount));  // Output: 3
    }
}
