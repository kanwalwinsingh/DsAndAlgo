package main.java.algorithms.subsetsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllpossiblesubsetOfIntegerArray {
    static int getBit(int num, int bit){
        int temp = (1<<bit);
        temp = temp&num;
        if(temp == 0)
            return 0;
        return 1;
    }

    static List<List<Integer>> findAllSubsets(int[] nums){
        List<List<Integer>> setLists = new ArrayList<>();
        if(nums.length!=0){
            int subsetsCount = (int) (Math.pow(2,nums.length));
            for(int i =0; i<subsetsCount; i++){
                List<Integer> subset = new ArrayList<>();
                for(int j =0; j<nums.length; j++){
                    if(getBit(i,j) == 1){
                        int x = nums[j];
                        subset.add(x);
                    }
                }
                setLists.add(subset);
            }
        }else{
            List<Integer> emptySet = new ArrayList<>();
            setLists.add(emptySet);
        }
        return setLists;
    }

    //using recursion
    public static List<List<Integer>> subsets(int[] nums){
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        List<Integer> input = new ArrayList<>();
        for (Integer num : nums){
            input.add(num);
        }
        cacSubset(input, res,subset,index);
        return res;

    }

    public static void cacSubset(List<Integer> A, List<List<Integer>> res,List<Integer> subset, int index){

        // Add the current subset to the result list
        res.add(new ArrayList<>(subset));
        //Generate subsets by recursively includng and excluding elements
        for(int i =index; i<A.size(); i++){
            subset.add(A.get(i));

            //Recusively generate subsets wit the current element including
            cacSubset(A, res,subset,i+1);

            //Exclude the current element from the subset
            subset.remove(subset.size()-1);
        }

    }

    public static void main(String[] args) {
        int[][] inputSets = {
                {},
                {2, 5, 7},
                {1, 2},
                {1, 2, 3, 4},
                {7, 3, 1, 5}
        };

        for (int i = 0; i < inputSets.length; i++) {
            int[] set = inputSets[i];
            System.out.println((i + 1) + ". Set: " + Arrays.toString(set));
            List<List<Integer>> subsets = findAllSubsets(set);
            System.out.println("   Subsets: " + subsets);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
