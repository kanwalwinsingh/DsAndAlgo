package Codility;

public class MetroFeeCalculator {
    public static int calculateTotalFee(int[] start, int[] dest, int[] limit) {
        int n = start.length;
        int maxStation = 0;

        // Find the maximum station number visited
        for (int i = 0; i < n; i++) {
            maxStation = Math.max(maxStation, start[i]);
            maxStation = Math.max(maxStation, dest[i]);
        }

        // Calculate the total fee
        int totalFee = 0;
        for (int i = 0; i < n; i++) {
            int travelFee = Math.abs(dest[i] - start[i]) * 2;
            int rideFee = 1 + travelFee;
            totalFee += rideFee;
        }

        // Retrieve the fee limit based on the maximum station number visited
        int feeLimit = limit[maxStation];

        // Ensure the total fee does not exceed the fee limit
        return Math.min(totalFee, feeLimit);
    }

    public static int calculateTotalFee2(int[] start, int[] dest, int[] limit) {
        int n = start.length;
        int maxStation = 0;



        // Calculate the total fee
        int totalFee = 0;
        for (int i = 0; i < n; i++) {
            int travelFee = Math.abs(dest[i] - start[i]);
            travelFee*=2;
            totalFee = totalFee + (1+travelFee);
        }

        for (int index = 0; index< n; index++){
            if(maxStation<start[index]){
                maxStation = start[index];
            }
            if(maxStation < dest[index]){
                maxStation = dest[index];
            }
        }

        int res = Integer.MAX_VALUE;
        if(res >limit[maxStation]){
            res = limit[maxStation];
        }
        if(res >totalFee){
            res = totalFee;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] start1 = {1, 0, 2, 4};
        int[] dest1 = {2, 2, 0, 5};
        int[] limit1 = {3, 17, 7, 4, 5, 17};
        System.out.println(calculateTotalFee2(start1, dest1, limit1)); // Output: 16

        int[] start2 = {2, 2};
        int[] dest2 = {4, 3};
        int[] limit2 = {1, 1, 1, 1, 9, 1};
        System.out.println(calculateTotalFee2(start2, dest2, limit2)); // Output: 8

        int[] start3 = {1,2,0,2,3};
        int[] dest3 = {2,1,2,1,2};
        int[] limit3 = {4,8,18,16,20};
        System.out.println(calculateTotalFee2(start3, dest3, limit3));
    }
}