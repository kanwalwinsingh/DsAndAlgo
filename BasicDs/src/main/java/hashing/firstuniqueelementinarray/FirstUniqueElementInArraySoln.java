package main.java.hashing.firstuniqueelementinarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FirstUniqueElementInArraySoln {
    public static int findFirstUnique(int[] nums){
        HashMap<Integer,Integer> countElements = new HashMap<>();
        for (int i =0; i< nums.length; i++){
            if(countElements.containsKey(nums[i])){
                int occurrence = countElements.get(nums[i])+1;
                countElements.put(nums[i], occurrence);
            }else{
                countElements.put(nums[i],1);
            }
        }
        for(int i =0; i< nums.length;i++){
            if(countElements.get(nums[i]) == 1){
                return nums[i];
            }
        }
        //If no such element is found, return -1;
        return -1;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {9, 2, 3, 2, 6, 6},
                {-5, -4, -4, 6, -1},
                {-1, 2, -1, -4, -10},
                {1, 1, 2, 9},
                {-2, 2, -2, 2, 5}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tInput Array: " + Arrays.toString(inputs[i]));
            System.out.println("\tFirst unique number: " + findFirstUnique(inputs[i]));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
