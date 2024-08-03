package main.java.algorithms.divideandconquer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MergeANumberOfSortedArray {
    public static int n = 4;

    public static ArrayList<Integer> mergeSortedArrayBruteForce(int[][] arr, ArrayList<Integer> output) {
        //traversing the 2-D array and appending all arrays into the Arraylist
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //adding into the arraylist
                output.add(arr[i][j]);
            }
        }
        //Sorting the ArrayList
        Collections.sort(output);
        return output;
    }

    public static void mergeArrays(int arr1[], int arr2[], int N1, int N2, int arr3[]) {
        int i = 0, j = 0, k = 0;
        // Traverse both array
        while (i < N1 && j < N2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < N1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < N2)
            arr3[k++] = arr2[j++];
    }

    public static void mergeKArrays(int[][] arr, int i, int j, int[] output) {
        //if one array is in range
        if (i == j) {
            for (int p = 0; p < n; p++) {
                output[p] = arr[i][p];
            }
            return;
            }

        //if only two arrays are left then merge them
        if (j - i == 1) {
            mergeArrays(arr[i], arr[j], n, n, output);
            return;
        }

        // output arrays
        int[] out1 = new int[n * (((i + j) / 2) - i + 1)];
        int[] out2 = new int[n * (j - ((i + j) / 2))];

        // divide the array into halves
        mergeKArrays(arr, i, (i + j) / 2, out1);
        mergeKArrays(arr, (i + j) / 2 + 1, j, out2);

        // merge the output array
        mergeArrays(out1, out2, n * (((i + j) / 2) - i + 1),
                n * (j - ((i + j) / 2)), output);
    }

    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String args[]) {
//        int[][] arr = {{16, 25, 36}, {2, 9, 15}, {22, 55, 67}, {79, 38, 99}};
//        ArrayList<Integer> Output = new ArrayList<Integer>();
//
//        System.out.print(mergeSortedArrayBruteForce(arr, Output));

        int arr[][] = {{ 16, 25, 36, 79 }, { 2, 9, 15, 38 }, { 22, 55, 67, 98 }};

        int K = arr.length;
        int[] output = new int[n * K];

        // Function call
        mergeKArrays(arr, 0, 2, output);

        System.out.print("Merged array is "
                + "\n");
        printArray(output, n * K);

    }
}
