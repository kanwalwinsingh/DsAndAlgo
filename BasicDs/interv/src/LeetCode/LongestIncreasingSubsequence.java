package LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int LengthOFLIS(int[] num){
        if(num == null || num.length == 0){
            return 0;
        }
        int maxlength = 1;
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i =1; i<n; i++){
            for(int j =0; j<i; j++){
                if(num[i]>num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlength = Math.max(maxlength,dp[i]);
        }
        return maxlength;
    }

    public int lengthOFLISOptimal(int[] nums){
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums){
            int pos = binarySearch(tails,0,size,num);
            tails[pos] = num;
            if(pos == size){
                size++;
            }
        }
        return size;
    }
    //custom binary search implementation
    private int binarySearch(int[] tails, int start, int end, int target){
        while (start<end){
            int mid = start + (end-start)/2;
            if (tails[mid]<target){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of Longest Increasing Subsequence: " + lis.lengthOFLISOptimal(nums));  // Output: 4
    }
}
