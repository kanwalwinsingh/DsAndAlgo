package main.java.hashing.findsumkwitheleminarray;

import java.util.*;

public class FindTwoElementInArrayWhoseSumIsKSoln {
    public static int[] findSum(int[] arr, int n){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int val= map.get(arr[i]);
                return new int[]{arr[i],val};
            }else {
               int sum = n-arr[i];
               map.put(sum,arr[i]);
            }
        }
        return new int[0];
    }

    public static int[] findSumUsingHashSet(int[] nums, int value){
        Set<Integer> foundValues = new HashSet<>();
        for(int num : nums){
            //Calculate the complement value needed to reach the value
            int complement = value-num;
            //Check if the complement value is already found in the foundvalues
            if(foundValues.contains(complement)){
                return new int[]{complement,num};
            }else {
                foundValues.add(num);
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}
        };

        int[] k = {5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);
            int[] result = findSumUsingHashSet(inputs[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
