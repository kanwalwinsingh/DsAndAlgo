package main.java.algorithms.divideandconquer;

import java.util.Arrays;

public class MissingNumberInTheArray {
    public static int missingNumber(int[] arr, int size){
        int missing = -1; // if no element is missing
        int last = arr[0]; // start off from the first element
        if(last != 1){
            return 1;
        }
        for(int i = 1; i< size; i++){ // traverse through the whole array
            if(arr[i]-last>1){
                missing = last+1;
                break;
            }
            last++;
        }
        return missing;
     }

     //binary search modified to find the missing element
    public static int missingNumberUsingBinarySearch(int[] arr, int size){
        int leftLimit = 0, rightLimit = size-1; // initalize limits
        if(arr[leftLimit]!=1){
            return 1;
        }
        while (leftLimit<=rightLimit){
            int middle = leftLimit + (rightLimit-leftLimit)/2;

            // Element at index `i` should be `i+1` (e.g. 1 at index 0). If this is the first element  which is not `i`+ 1, then  missing element is middle+1
            if(arr[middle] != middle+1 && arr[middle-1] == middle ){
                return middle+1;
            }
            //if this is not the first element missing search the left subarray
            if(arr[middle] != middle+1){
                rightLimit = middle-1;
            }else {
                leftLimit = middle+1;
            }

        }
        return -1;
    }

    public static void main(String args[]) {
        int[] input1 = {1,2,4};
        int[] input2 = {1,2,3,4,6};
        int[] input3 = {2,3,4,5,6};
        int[] input4 = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Find the Missing Number!");
        System.out.println(Arrays.toString(input1) + " --> " + missingNumberUsingBinarySearch(input1, input1.length));
        System.out.println(Arrays.toString(input2) + " --> " + missingNumberUsingBinarySearch(input2, input2.length));
        System.out.println(Arrays.toString(input3) + " --> " + missingNumberUsingBinarySearch(input3, input3.length) + "\t\t\t\t\t\t Corner Case I - Handeled");
        System.out.println(Arrays.toString(input4) + " --> " + missingNumberUsingBinarySearch(input4, input4.length) + "\t\t\t Corner Case II - Handeled");
    }
}
