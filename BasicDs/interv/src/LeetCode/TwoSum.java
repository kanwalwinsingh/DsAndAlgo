package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> intMap = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            int complement = target-nums[i];
            if(intMap.containsKey(complement)){
                return new int[]{i, intMap.get(complement)};
            }else {
                intMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
