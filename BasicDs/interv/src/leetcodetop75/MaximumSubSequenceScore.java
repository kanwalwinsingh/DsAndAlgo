package leetcodetop75;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubSequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k){
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        //Create pairs of (nums1[i], nums[2]) and sort them by nums2[i] descending
        for(int i =0; i<n; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a,b)->b[1]-a[1]);

        //Use a min-heap to maintain the largest k element of nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sum = 0;
        long maxScore = 0;

        for(int i =0; i<n; i++){
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];

            //Add num1 to the heap and the sum
            minHeap.offer(num1);
            sum+= num1;

            //If the heap exceeds size k, remove the smallest elment from the heap and adjust the sum
            if(minHeap.size() >k){
                sum-=minHeap.poll();
            }
            //If we have exactly k elements, calculate the score
            if(minHeap.size() == k){
                maxScore = Math.max(maxScore, sum*num2);
            }
        }
        return maxScore;
    }

    // Driver code
    public static void main(String[] args) {
        MaximumSubSequenceScore solution = new MaximumSubSequenceScore();

        int[] nums1_1 = {1, 3, 3, 2};
        int[] nums2_1 = {2, 1, 3, 4};
        int k1 = 3;

        int[] nums1_2 = {4, 2, 3, 1, 1};
        int[] nums2_2 = {7, 5, 10, 9, 6};
        int k2 = 1;

        System.out.println("Test Case 1: " + solution.maxScore(nums1_1, nums2_1, k1)); // Expected Output: 12
        System.out.println("Test Case 2: " + solution.maxScore(nums1_2, nums2_2, k2)); // Expected Output: 30
    }
}
