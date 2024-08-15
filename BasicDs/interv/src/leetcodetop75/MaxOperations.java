package leetcodetop75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k){
        Arrays.sort(nums); // Step 1 : Sort the array
        int left = 0; // Pointer at the start of the array
        int right = nums.length -1; // Pointer at the end of the array
        int operations = 0; // Counter for the number of operations

        while (left<right){
            int sum = nums[left] + nums[right];
            if(sum == k){
                operations++; //We found a valid pair
                left++;
                right--;
            } else if (sum<k) {
                left++;
            }else {
                right--;
            }
        }
        return operations;
    }
}
