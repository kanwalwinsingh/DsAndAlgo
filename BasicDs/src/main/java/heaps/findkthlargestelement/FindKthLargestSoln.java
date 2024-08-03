package main.java.heaps.findkthlargestelement;

import java.util.Arrays;

public class FindKthLargestSoln {

    public static int[] findKLargest(int[] nums, int k){
        MaxHeap maxHeap = new MaxHeap();
        for(int num : nums){
            maxHeap.push(num);
        }
        int[] kLargest = new int[k];

        for(int i =0; i<k; i++){
            kLargest[i] = maxHeap.pop();
        }
        return kLargest;
    }

    static int[] findKLargestUsingSort(int[] nums, int k){
        //Sort the array of number
        Arrays.sort(nums);
        int[] result = new int[k];
        int index = 0;
        int arrayLength  =nums.length;
        int counterTorun = arrayLength-k;
        for(int i =arrayLength-1; i>=counterTorun; i--){
            result[index++] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 6, 8, 2, 9},
                {10, -20, -40, -30, 50, -10, 90},
                {1, -2, 3, -4, 5, -6, 7},
                {90},
                {11, 41, 71, 91, 31}
        };

        int[] size={6, 7, 7, 1, 5};
        int[] k= {3, 5, 7, 1, 5};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i+1 + ".\tArray: " + Arrays.toString(nums[i]));
            System.out.println("\tK: " + k[i]);

            int[] result = findKLargestUsingSort(nums[i], k[i]);

            System.out.print("\tK Largest elements: " + Arrays.toString(result) + "\n");
            StringBuilder dashes = new StringBuilder();
            for (int j = 0; j < 100; j++) {
                dashes.append("-");
            }
            System.out.println(dashes.toString());
        }
    }

}
