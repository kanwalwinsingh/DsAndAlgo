package main.java.algorithms.searching.binarysearch.dutchnationalflagproblem;

import java.util.Arrays;

// sort array of 0 1 and 2
public class DutchNationalFlagProblem {
    //Sorting in ascending order using selection sort
    public static int[] selectionSort(int[] lst){
        int size = lst.length;
        int index = 0;
        for(int i =0; i< size; i++){
            //finding the minimum value's index
            index = find_min(lst,i,size);
            //swapping it with current value
            int temp = lst[i];
            lst[i] = lst[index];
            lst[index] = temp;
        }
        return lst;
    }

    //function to find the index of the minimum value
    public static int find_min(int[] lst, int start, int end){
        int min = lst[start];
        int index = start;
        for(int i = start; i<end; i++){
            if(lst[i]<min){
                min = lst[i];
                index = i;
            }
        }
        return index;
    }

    public static void mySwap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void dutchNationalFlag(int[] arr){
        int i =0;
        int mid = 0;
        int j = arr.length -1;
        while (mid<= j){
            //if value at mid equal to 0
            if(arr[mid] == 0 ){
                mySwap(arr,i++,mid++);
            } else if (arr[mid] == 2) { // if value equal to 2
                mySwap(arr,mid,j--);
            } else if (arr[mid] == 1) {
                mid++;
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {
                2,
                0,
                0,
                1,
                2,
                1
        };
        dutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr));

    }

}
