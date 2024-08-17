package agoda;

import java.util.Map;

public class MaximumSumSubArray {
    public static int maxSubArraySum(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int maxEndingSoFar = nums[0];
        int maxSum = nums[0];
        for(int m = 0; m<nums.length; m++){
            maxEndingSoFar = Math.max(nums[m],maxEndingSoFar+nums[m]);
            maxSum = Math.max(maxSum,maxEndingSoFar);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(nums);
        System.out.println("Maximum sum of contiguous subarray: " + maxSum);
    }
}
