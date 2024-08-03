package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i =0; i<n; i++){
            pq.offer(nums[i]);
        }
        for (int i =1; i<k; i++){
            pq.poll();
        }
        return pq.poll();
    }

    public int findAnotherWay(int[] nums, int k){
        // Min-Heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.add(num);
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();

    }

    public int findUsingStreams(int[] nums, int k){
       return Arrays.stream(nums).sorted().toArray()[nums.length-k];
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(a,4));
    }
}
