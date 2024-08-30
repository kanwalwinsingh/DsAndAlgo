package expedia;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums){
        int totalSum = 0;
        for(int num : nums){
            totalSum +=num;
        }

        // If total sum is odd, we cannot partition it into two equals subsets
        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum /2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true; // We can always achieve a sum of 0 by choosing no elements

        for(int num : nums){
            for(int j = target; j>=num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        // Test cases
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solution.canPartition(nums2)); // Output: false
    }
}
