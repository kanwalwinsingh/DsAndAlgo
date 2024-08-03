package nikhil_lohia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationAllProblem {

    public List<List<Integer>> permuteDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backTrackWithDup(results,new ArrayList<>(),nums);
        return results;
    }
    public void backTrackWithDup(List<List<Integer>> results, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        }
            for (int i = 0; i<nums.length; i++){
//
               if (tempList.contains(nums[i])){
                   continue;
               }
                tempList.add(nums[i]);
                backTrackWithDup(results,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }

        public List<List<Integer>> permuteUnique(int[] nums){
            List<List<Integer>> results = new ArrayList<>();
            backtrackwithoutDup(results,new ArrayList<>(),nums,new boolean[nums.length]);
            return results;
        }

        public void backtrackwithoutDup(List<List<Integer>> results, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length && !results.contains(tempList)){
            results.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrackwithoutDup(results,tempList,nums,used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
        }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        PermutationAllProblem permutationAllProblem = new PermutationAllProblem();
        System.out.println(permutationAllProblem.permuteUnique(nums));
    }
}
