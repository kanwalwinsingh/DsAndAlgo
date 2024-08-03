package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthContigousSubArrayBinary {
    public static int findMaxLength(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // Initialize with prefix sum 0 at index -1;
        int maxLength = 0;
        int prefixSum = 0;
        for(int i = 0; i< nums.length; i++){
            prefixSum += nums[i] == 0? -1: 1;

            //Check if the prefix sum has been seen before
            if(map.containsKey(prefixSum)){
                //calculate the llength of the subarray
                maxLength = Math.max(maxLength,i-map.get(prefixSum));
            }else{
                map.put(prefixSum,i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 0,1, 1, 0, 1};
        System.out.println(findMaxLength(nums));  // Output: 6
    }
}
