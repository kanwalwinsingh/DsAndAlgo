package Codility;

public class MaxProfit {
    public static int solution(int[] A ){
        if(A.length <2){
            return 0;
        }
        int max_ending = A[0];
        int max_slice = Integer.MIN_VALUE;
        for (int i =1; i<A.length; i++){
            max_ending = Math.min(max_ending,A[i]);
            int profit = A[i] - max_ending;
            max_slice = Math.max(max_slice,profit);
        }
        return max_slice;
    }
    /*  If it is only one or less prices in the array, we can't do
           buy&sell transaction, i.e. we can't make any profit.
           For larger arrays of prices we calculate max profit
           if we buy at a minimum price and sell at current price.
           Then we check if the current price is minimum. And the
           resulting max profit will be either current profit or
           previous max profit we found before */
    public static int exampleSolln(int[] A){
        int maxCurrent = 0, maxProffit = 0, minprice = A[0];
        for(int i : A){
            maxCurrent = Math.max(0,i-minprice);
            minprice = Math.min(minprice,i);
            maxProffit = Math.max(maxCurrent,maxProffit);
        }
        return maxProffit;
    }

    public static void main(String[] args) {
        int[] A = {23171,21011,21123,21366,21013,21367};
        System.out.println(solution(A));
    }
}
