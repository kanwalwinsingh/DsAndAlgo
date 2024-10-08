package main.java.algorithms.sorting;

import java.util.Random;

public class QuickSort {
    static Helper obj = new Helper();
    public static int choosePivot(int left , int right){
        Random random = new Random();
        //Pick 3 random numbers within the range of the array
        int i1 = left + (random.nextInt(right-left+1));
        int i2 = left + (random.nextInt(right-left+1));
        int i3 = left + (random.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(i1,i2),Math.min(Math.max(i1,i2),i3));
    }

    public static int partition(int arr[], int left, int right){
        int pivotInd = choosePivot(left,right);
        obj.swap(arr,right,pivotInd); // self created function to swap indices of an array
        int pivot = arr[right];
        int i = (left-1); // All the elements less than or equal to the pivot go before or at i
        for(int j = left; j<=right-1; j++){
            if(arr[j] <= pivot){
                i++;
                obj.swap(arr,i,j);
            }
        }
        obj.swap(arr,i+1,right);
        return (i+1);
    }

    public static void quickSort(int arr[], int left, int right){
        if(left<right){
            //pi is where the pivot is at
            int pi = partition(arr,left,right);
            // seperatly sort the element before and after partition
            quickSort(arr,left,pi-1);
            quickSort(arr,pi+1,right);
        }

    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        quickSort(arr, 0, arrSize - 1);
        System.out.print("Sorted array: ");
        obj.printArray(arr, arrSize);
    }
}
