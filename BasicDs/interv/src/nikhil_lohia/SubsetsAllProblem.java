package nikhil_lohia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsAllProblem {

    public List<List<Integer>> subsetWithoutDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrackWithoutDup(result,new ArrayList<>(),nums,0);
        return result;
    }

    public void backtrackWithoutDup(List<List<Integer>> result, List<Integer> temp,int[] nums, int start){
        result.add(new ArrayList<>(temp));
        for(int i =start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrackWithoutDup(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackWithDup(result,new ArrayList<>(),nums,0);
        return result;
    }

    public void backtrackWithDup(List<List<Integer>> results, List<Integer> temp,
                                 int[] nums, int start){

        results.add(new ArrayList<>(temp));
        for (int i = start; i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrackWithDup(results,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SubsetsAllProblem subsetsAllProblem = new SubsetsAllProblem();
        System.out.println(subsetsAllProblem.subsetWithoutDup(nums));

        int[] nums1 = {1,2,2};
        SubsetsAllProblem subsetsAllProblem1 = new SubsetsAllProblem();
        System.out.println(subsetsAllProblem1.subsetWithDup(nums1));

    }
}
