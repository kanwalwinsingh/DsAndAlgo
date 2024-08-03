package main.java.algorithms.bruteforce;

public class Maximum {
    public static int maximum_index(int array[], int array_size){
        int max_index = 0;
        int max_val = Integer.MIN_VALUE;
        for (int i =0; i< array_size; i++){
            if(max_val<array[i]){
                max_val = array[i];
                max_index = i;
            }
        }
        return max_index;
    }
     public static void main(String args[]) {
         int array_size = 9;
         int nums[] = {2, 4, 6, 3, 5, 7, 9, 1, 8};
         int max_index = maximum_index(nums, array_size);
         System.out.println("The MAX number " + nums[max_index] + " is found at index " + max_index);
     }}
