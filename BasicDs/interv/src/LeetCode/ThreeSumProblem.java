package LeetCode;

import java.util.*;

public class ThreeSumProblem {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int  i =0; i< nums.length - 2; i++){
            //skip duplicate elements
            if(i>0 && nums[i] == nums[i-1]) continue;

            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j<nums.length; j++){
                if(set.contains(target-nums[j])){
                    result.add(Arrays.asList(nums[i],target-nums[j], nums[j]));

                    //skip duplicates for j
                    while (j+1<nums.length && nums[j] == nums[j+1]){
                        j++;
                    }
                }
                set.add(nums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(A);
        System.out.println(lists);
    }



}
