package leetCodeTopInterview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,((a,b)->b-a));
        int n = nums.length;
        int[] result = new int[n-k+1];
        for(int i = 0; i<k; i++){
            pq.add(nums[i]);
        }
        result[0] = pq.peek();
        int index =1;
        for(int i = k; i<n && index<result.length; i++, index++){
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            result[index] = pq.peek();
        }
        return result;
    }

    public int[] maxSlidingWindowOptimal(int[] nums, int k){
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i<n; i++){
            //Remove elements not in the sliding window
            if(!deque.isEmpty() && deque.peekFirst() < i - k+1){
                deque.pollFirst();
            }

            //Remove elements smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }

            //Add current elements index to the dequeue
            deque.offerLast(i);

            //Start recording results from the point where the first window is complete
            if(i >= k-1){
                result[i-k +1] = nums[deque.peekFirst()];
            }
        }
            return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sl = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sl.maxSlidingWindowOptimal(nums,3)));
    }
}
