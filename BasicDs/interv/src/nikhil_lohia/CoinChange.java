package nikhil_lohia;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount<1){
            return 0;
        }
        int[] minConsDp = new int[amount+1];

        for(int i =1; i<=amount; i++) {
            minConsDp[i] = Integer.MAX_VALUE;

            //Try each coin
            for (int coin : coins) {
                if (coin <= i && minConsDp[i-coin] != Integer.MAX_VALUE){
                    minConsDp[i] = Math.min(minConsDp[i],1+minConsDp[i-coin]);
                }
            }
        }
        return minConsDp[amount] == Integer.MAX_VALUE ?-1 : minConsDp[amount];
    }
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount));  // Output: 3
    }
}
