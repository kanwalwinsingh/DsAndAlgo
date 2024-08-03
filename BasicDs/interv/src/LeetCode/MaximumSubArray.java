package LeetCode;

public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    public static int[] maxSubArrayWithIndex(int[] nums){
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        int start = 0, end =0, tempStart =0;
        for (int i =0; i<nums.length; i++){
            if(nums[i] >maxCurrent+nums[i]){
                maxCurrent = nums[i];
                tempStart = i;
            }else {
                maxCurrent+=nums[i];
            }
            if(maxGlobal<maxCurrent){
                maxGlobal = maxCurrent;
                start = tempStart;
                end = i;
            }
        }
        return new int[]{maxGlobal,start,end};
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArrayWithIndex(nums);
        System.out.println("Maximum sum: " + result[0]); // Output: 6
        System.out.println("Starting index: " + result[1]); // Output: 3
        System.out.println("Ending index: " + result[2]); // Output: 6
    }


}
