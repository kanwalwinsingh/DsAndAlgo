package leetcodetop75;

public class StockSellWithTransactionFees {
    public int maxProfit(int[] prices, int fee){
        //Edge case: if prices array is empty, return 0 profit
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int hold = -prices[0]; // max profit if holding a stock after day 0;
        int cash = 0; // max profit if not holding a stock after day 0
        for(int i = 1; i<n; i++){
            //Update the cash and hold states based on the days price
            cash = Math.max(cash,hold+prices[i] - fee);
            hold = Math.max(hold,cash-prices[i]);
        }
        // Return the max profit possible if not holding any stock at the end
        return cash;
    }
    public static void main(String[] args) {
        StockSellWithTransactionFees solution = new StockSellWithTransactionFees();

        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println("Maximum profit: " + solution.maxProfit(prices1, fee1));
        // Expected output: 8

        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println("Maximum profit: " + solution.maxProfit(prices2, fee2));
        // Expected output: 6
    }
}
