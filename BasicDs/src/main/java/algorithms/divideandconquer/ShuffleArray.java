package main.java.algorithms.divideandconquer;

import java.util.Arrays;

import static main.java.algorithms.searching.Helper.swap;

public class ShuffleArray {
    public static void shuffleArrBruteForce(int arr[], int size){ // Swap elements from left to right
        for(int  i =0, q =1, k = size; i<size; i++, q++,k++){
            for(int j = k; j>i+q; j--)
                swap(arr,j-1,j);
        }
    }

    public static void shuffleArrayUtil(int arr[], int left, int right)
        {

            if (right - left <= 1) // Base case: return array if only 2 elements are remaining
                return;

            int middle = left + (right-left) / 2; // compute middle index
            int temp = middle + 1; // first half of second array
            int mmiddle = left + (middle-left) / 2; // second half of first array

            for (int i = mmiddle + 1; i <= middle; i++) // swapping elements for subarray
                swap(arr, i, temp++);

            // Pass splitted first and second half of the array to utility function
            shuffleArrayUtil(arr, left, middle);
            shuffleArrayUtil(arr, middle + 1, right);
        }


    public static Object ShuffleArray(int arr[]) {

        int size = arr.length;
        if (size == 2) // corner case 1 check
        {
            System.out.println("After: " + Arrays.toString(arr));
            return true;
        } else if (size % 2 != 0) // corner case 2 check
        {

            System.out.println("After: " + Arrays.toString(arr));
            return false;
        } else {

            shuffleArrayUtil(arr, 0, size -1 );
            System.out.println("After: " + Arrays.toString(arr));
            return true;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j ] = temp;
    }
    public static void main( String args[] )
    {
        int [] arr = {3, 5, 7, 9, 11, 13};
        shuffleArrBruteForce(arr, arr.length/2);
        System.out.println( Arrays.toString(arr) );

        int[][] arry = {{0, 1}, { 11, 12, 13}, {0, 1, 2, 3, 4, 5}, { 1, 3, 5, 7, 2, 4, 6, 8 }};
        boolean check = true;
        for (int i = 0; i < arry.length; i++) {
            System.out.println("Before: " + Arrays.toString(arry[i]));
            ShuffleArray(arry[i]);
            System.out.println();
        }
    }
    }

