package agoda;

import java.util.Arrays;

public class MaxFrequency {
    public int maxFrequency(int[] nums, int k){
        //Step 1: sort the array
        Arrays.sort(nums);

        //Initalize variables
        int left = 0;
        int maxFrequency = 1;
        long total = 0;

        //Step 2: Sliding window
        for(int right = 0; right<nums.length; right++){
            //Calculate total operations needed to make all elements in the window equal to nums[right]
            total +=(long) nums[right];

            //If the operation excedded k, shrink the window
            while ((long)nums[right] * (right - left + 1) > total+k){
                total -=nums[left];
                left++;
            }

            //Update maxFrequency
            maxFrequency = Math.max(maxFrequency, right-left + 1);
        }
        return maxFrequency;

    }
    public static void main(String[] args) {
        MaxFrequency mf = new MaxFrequency();
        int[] nums = {1, 2, 4};
        int k = 5;
        System.out.println(mf.maxFrequency(nums, k)); // Output: 3
    }
}