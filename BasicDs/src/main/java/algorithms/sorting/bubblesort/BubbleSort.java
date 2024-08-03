package main.java.algorithms.sorting.bubblesort;

import main.java.algorithms.sorting.Helper;

public class BubbleSort {
    static Helper obj = new Helper();
    static void bubbleSort(int arr[], int arrSize){
        int i, j, temp;
        //Traverse through all array element
        for(i =0; i< arrSize-1; i++){
            //last i elem are already in place
            for(j =0; j<arrSize-i-1; j++){
                //Traverse the array from 0 to size of array[i-1]
                //Swap the elem found is greater than the next elem
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        bubbleSort(arr, arrSize);
        obj.printArray(arr, arrSize);
    }
}
