package main.java.algorithms.bruteforce;

public class FindNumInArray {
    public static int find_index(int array[], int to_find, int array_size){
        for(int i =0; i< array_size; i++){
            if(array[i] == to_find){
                return i;
            }
        }
        return -1;
    }

    public static int minimum_index(int array[], int array_size){
        int minIndex =0;
        int minVal = Integer.MAX_VALUE;
        for (int i =0; i< array_size; i++){
            if(minVal>array[i]){
                    minVal = array[i];
                    minIndex = i;
            }
        }
        return minIndex;
    }
    public static void main(String args[]) {
        int number_to_search = 7;
        int array_size = 9;
        int nums[] = {2,4,6,3,5,7,9,1,8};
        int index_found = find_index(nums, number_to_search, array_size);

        if (index_found != -1)
            System.out.println("The number " + number_to_search + " is found at " + index_found);

        else
            System.out.println("The number " + number_to_search + " is NOT found");

         array_size = 9;
        int nums1[] = {2,4,6,3,5,7,9,1,8};
        int min_index = minimum_index(nums1, array_size);

        System.out.println("The MIN number " + nums1[min_index] + " is found at index " + min_index);
    }
}


