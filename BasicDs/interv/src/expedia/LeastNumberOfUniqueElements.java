package expedia;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueElements {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        //Step 1: Count the frequency of each integer in the array
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //Step 2: Add all frequencies to a priority queue
       PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());

        //Step 3: Remove k elements by removing from the heap
        while (k>0 && !pq.isEmpty()){
            k-=pq.poll();
        }

        //Step 4: if k is negative, we've rempved part of a group, so add 1 back to the result
        int uniqueIntegerResult = pq.size();
        if(k<0){
            uniqueIntegerResult++;
        }
        return uniqueIntegerResult;

    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,3,3,3};
        int k = 3;
        System.out.println("Least number of unique integers after removing " + k + " elements: " + findLeastNumOfUniqueInts(arr, k)); // Output: 3
    }
}
