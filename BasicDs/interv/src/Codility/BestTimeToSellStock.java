package Codility;

public class BestTimeToSellStock {
    public static int soln(int[] arr){
        int max_sell = arr[0];
        int max_Benefit = Integer.MIN_VALUE;
        for(int i = 1; i< arr.length; i++){
            max_sell = Math.min(max_sell,arr[i]);
            int profit = arr[i]-max_sell;
            max_Benefit = Math.max(max_Benefit,profit);
        }
        return max_Benefit;
    }

    public static void main(String[] args) {
        System.out.println(soln(new int[]{7, 6, 4, 3, 1} ));
    }
}
