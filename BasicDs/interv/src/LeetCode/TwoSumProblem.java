package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSums(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
