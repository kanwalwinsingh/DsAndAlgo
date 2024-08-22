package expedia;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int k = nums.length;

        int[] dp = new int[k];
        int maxLength = 1;

        Arrays.fill(dp, 1);

        for(int m = 1; m<k; m++){
            for(int n = 0; n<m; n++){
                if(nums[n] < nums[m]){
                    dp[m] = Math.max(dp[m], dp[n]+1);
                }
            }
            maxLength = Math.max(dp[m],maxLength);
        }
        return maxLength;
    }

    public static int lengthOfLISOptimal(int[] nums){
        int m = nums.length;
        int[] tails = new int[m];
        int size = 0;
        for(int i = 0; i< m; i++){
            int pos = binarySearch(0,size,nums[i],tails);
            tails[pos] = nums[i];
            if(pos == size){
                size++;
            }
        }
        return size;
    }




    public static int binarySearch(int start, int end, int target, int[] tails){
        while (start<end){
            int mid = start + (end-start)/2;
            if(tails[mid]< target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = lengthOfLISOptimal(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + length); // Output: 4
    }
}
