package leetcodetop75;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumAverageSubArray1 {
    public double findMaxAverage(int[] nums, int k){
        //Step 1: Calculate the sum of the first k elements(intial window)
        int n = nums.length;
        double maxSum = 0;
        for(int i = 0; i< k; i++){
            maxSum += nums[i];
        }
        double currentSum = maxSum;

        for(int i = k; i<n; i++){
            currentSum +=nums[i] - nums[i-k]; // update the window
            maxSum = Math.max(currentSum,maxSum);
        }

        //Step 3: return the maximum average
        return maxSum/k;
    }
    public static void main(String[] args) {
        MaximumAverageSubArray1 solution = new MaximumAverageSubArray1();

        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Maximum Average: " + solution.findMaxAverage(nums1, k1));

        int[] nums2 = {5, 5, 5, 5, 5, 5, 5, 5};
        int k2 = 3;
        System.out.println("Maximum Average: " + solution.findMaxAverage(nums2, k2));

        int[] nums3 = {-1, -12, -5, -6, -50, -3};
        int k3 = 2;
        System.out.println("Maximum Average: " + solution.findMaxAverage(nums3, k3));
    }
}
