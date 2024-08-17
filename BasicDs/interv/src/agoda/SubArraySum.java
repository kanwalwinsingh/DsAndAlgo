package agoda;

import java.util.HashMap;
import java.util.HashSet;

public class SubArraySum {
    public static int countSubArrayWithSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cumulativeSum = 0;
        int count = 0;

        //Initalize the map with the cumulative sum 0 having one occurance
        map.put(0,1);

        for (int num : nums) {
            cumulativeSum += num;

            int complementry = cumulativeSum - target;
            if (map.containsKey(complementry)) {
                count += map.get(complementry);
            }

            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, -1};
        int target = 2;

        int result = countSubArrayWithSum(nums, target);
        System.out.println("Number of subarrays with sum " + target + ": " + result);
    }
}
