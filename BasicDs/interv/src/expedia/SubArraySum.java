package expedia;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> intMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        intMap.put(0,1);
        for (int i = 0; i< nums.length; i++){
            sum +=nums[i];
            if(intMap.containsKey(sum-k)){
                ans += intMap.get(sum-k);
            }
            intMap.put(sum,intMap.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1};
        int k = 2;
        SubArraySum
        solution = new SubArraySum();
        int result = solution.subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }
}
