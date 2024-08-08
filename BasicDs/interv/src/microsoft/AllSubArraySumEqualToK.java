package microsoft;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class AllSubArraySumEqualToK {
    public int subArraySum(int[] nums, int k) {
    int sum = 0;
    int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j =0; j<nums.length; j++){
            sum+=nums[j];
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
