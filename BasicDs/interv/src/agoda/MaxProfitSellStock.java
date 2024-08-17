package agoda;

public class MaxProfitSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minBuy = prices[0];
        for(int i =1; i<n; i++){
            if(minBuy<prices[i]){
                maxProfit = Math.max(maxProfit,prices[i]-minBuy);
            }else{
                minBuy = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit); // Output should be 5
    }
}
