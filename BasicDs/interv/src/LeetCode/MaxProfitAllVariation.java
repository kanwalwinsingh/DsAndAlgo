package LeetCode;

public class MaxProfitAllVariation {
    /**
     * variation 1 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1330104409/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
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

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
    public int maxProfitII(int[] prices) {
        int profit = 0;
        for(int i =0; i< prices.length-1; i++){
            if(prices[i]<prices[i+1]){
                profit= profit+(prices[i+1]-prices[i]);
            }else{
                continue;
            }
        }
        return profit;
    }
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
     */
    public int maxProfitIII(int[] prices) {
       if (prices == null || prices.length == 0){
           return 0;
       }

       int n = prices.length;

       //step 1: Track forward profit
        int[] forwardProfit = new int[n];
        int minPrice = prices[0];
        for(int i = 1; i<n; i++){
            minPrice = Math.min(minPrice,prices[i]);
            forwardProfit[i] = Math.max(forwardProfit[i-1],prices[i]-minPrice);
        }

        //Step 2: track backward profit
        int[] backwardProfit = new int[n];
        int maxPrice = prices[n-1];
        for(int j = n-2; j>=0; j--){
            maxPrice = Math.max(maxPrice,prices[j]);
            backwardProfit[j] = Math.max(backwardProfit[j+1],maxPrice-prices[j]);
        }

        //Step 3: Combine both profits
        int maxProfit =0;
        for (int i =0; i<n;i++){
            maxProfit = Math.max(maxProfit,forwardProfit[i]+backwardProfit[i]);
        }
        return maxProfit;


    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        MaxProfitAllVariation m = new MaxProfitAllVariation();
        System.out.println(m.maxProfitIII(prices));
    }
}
