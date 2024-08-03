package main.java.algorithms.sorting.findsuminaray;

import main.java.algorithms.searching.binarysearch.BinarySearch;
import main.java.algorithms.sorting.QuickSort;

public class CheckSumValueWithTwoElemInArray {
    public static int[] findSum(int[] arr, int n){ // time complexity is o(nlogn)
        QuickSort.quickSort(arr,0,arr.length-1);
        int[] elem = new int[2];
        int foundIndex = 0, arrSize = arr.length;
        for(int i =0; i< arrSize; i++){
            //using binary search to find the index of the value that sum to n
            //after addition with the value at current Index

            foundIndex = BinarySearch.binarySearch(n-arr[i],arr,arrSize);
            if(foundIndex != -1){
                elem[0] = arr[i];
                elem[1] = arr[foundIndex];
                return elem;
            }
        }
        return elem;
    }


    public static void main(String args[]) {
        int n = 9;
        int[] arr1 = {2, 4, 5, 7, 8};
        int[] arr2 = findSum(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if ((num1 + num2) != n)
            System.out.println("Results not found!");
        else
            System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }
}
