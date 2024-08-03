package main.java.algorithms.divideandconquer;

import java.util.Arrays;

public class ClosernumberToSortedArray {
    // The method finds the closer of 2 number to the target - assuming that `second` is greater than `first` and `target` lies in the middle
    public static int closer(int first, int second, int target){
        if(target-first>= second-target)
            return second;
        else
            return first;
    }

    //Returns the closet number to 'target' from the input array 'arr[]'
    public static int closestNumber(int arr[], int target){
        int n = arr.length;
        //Dealing with the boundry case
        if(target<= arr[0]) // if target is lesser than starting numbe than starting number is clost to target
            return arr[0];

        if(target>= arr[n-1]) // if it closest to last number than the last number is our answer
            return arr[n-1];

        int i = 0, j = n, mid =0;
        while (i<j){
            mid = i + (j-i)/2;
            if(arr[mid] == target)
                return arr[mid];
            if(target< arr[mid]){
                if(mid >0 && target > arr[mid-1]){
                    return closer(arr[mid-1],arr[mid], target);
                }
                j = mid;
            }
            else{
                if(mid<n-1 && target<arr[mid+1]){
                    return closer(arr[mid], arr[mid+1],target);
                }
                i = mid+1;
            }
        }
        return arr[mid]; // one element left after search, that must be closest
    }
    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 };
        int target = 11;
        System.out.println(Arrays.toString(arr) + "\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr, target));

        int arr1[] = {3,5,7,9,11,17};
        target = 10;
        System.out.println(Arrays.toString(arr1) + "\t\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr1, target));
    }
}
