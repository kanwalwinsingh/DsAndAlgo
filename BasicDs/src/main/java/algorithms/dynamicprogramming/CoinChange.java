package main.java.algorithms.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static int calculateMinimumCoins(int [] coins, int rem, int [] counter)
    {
        int result = 0;
        if(rem < 0)
            return -1;
        if(rem == 0)
            return 0;
        if(counter[rem - 1] != Integer.MAX_VALUE)
            return counter[rem - 1];
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++)
        {
            result = calculateMinimumCoins(coins, rem - coins[j], counter);
            if(result >= 0 && result < minimum)
                minimum = 1 + result;
        }
        if(minimum != Integer.MAX_VALUE)
            counter[rem - 1] = minimum;
        else
            counter[rem - 1] = -1;
        return counter[rem -1];
    }
    public static int coinChange(int[] coins, int total){
        if(total<1){
            return 0;
        }
        int[] l = new int[total];
        Arrays.fill(l,Integer.MAX_VALUE);
        return calculateMinimumCoins(coins,total,l);
    }

    // Driver code
    public static void main(String args[]) {
        int[][] coins = {{2, 3, 4, 5},
                {1, 4, 6, 9},
                {6, 7, 8},
                {1, 2, 3, 4, 5},
                {14, 15, 18, 20}};
        int[] total = {7, 11, 27, 41, 52};
        for (int i = 0; i < total.length; i++) {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from " + Arrays.toString(coins[i]) + " is: " + coinChange(coins[i], total[i]));
            System.out.println("------------------------------------------------");
        }

    }
}
