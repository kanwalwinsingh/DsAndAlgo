package main.java.algorithms.sorting.insertionsort;

import main.java.algorithms.sorting.Helper;

public class InsertionSort {
    static Helper obj = new Helper();
    static void insertionSort(int[] arr, int arrSize){
        int ele, j;
        //Traverse through 1 to size of the array
        for(int i =1; i<arrSize; i++) {
            ele = arr[i]; //element to be inserted
            j = i - 1;

            //shift element back to create space for the element to be inserted
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = ele;
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        insertionSort(arr, arrSize);
        obj.printArray(arr, arrSize);
    }
}
