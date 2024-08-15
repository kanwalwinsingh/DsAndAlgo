package leetcodetop75;

/**
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class PivotIndex {
    public int pivotIndex(int[] nums){
        int totalSum = 0;
        int leftSum = 0;

        //Calculate the total sum of the array
        for(int num : nums){
            totalSum +=num;
        }

        // Iterate through the array to find the pivot index
        for(int i =0; i<nums.length; i++){
            if(leftSum == totalSum-leftSum-nums[i]){
                return i;
            }
            //Update the left sum
            leftSum += nums[i];
        }
        //return -1 if no pivot element is found
        return -1;
    }
    public static void main(String[] args) {
        PivotIndex solution = new PivotIndex();

        int[] nums = {1, 7, 3, 6, 5, 6};

        int result = solution.pivotIndex(nums);
        System.out.println("The pivot index is: " + result);
    }
}
