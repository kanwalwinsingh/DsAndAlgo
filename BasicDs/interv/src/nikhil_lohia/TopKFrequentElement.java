package nikhil_lohia;

import java.util.*;

public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        if(nums.length == 1){
            return nums;
        }
        Map<Integer,Integer> myMap = new HashMap<>();
        int[] result = new int[k];
        List<Integer>[] bucket = new List[nums.length+1];
        for(int num : nums){
            myMap.put(num,myMap.getOrDefault(num,0)+1);
        }
        for(int key : myMap.keySet()){
            int frequency = myMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int counter = 0;
       for(int pos = bucket.length-1; pos>=0 && counter<k; pos-- ){
           if (bucket[pos] != null){
               for (Integer integer : bucket[pos]){
                   result[counter++] = integer;               }
           }
       }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
}
