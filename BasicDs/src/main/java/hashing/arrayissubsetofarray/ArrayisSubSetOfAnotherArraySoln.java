package main.java.hashing.arrayissubsetofarray;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayisSubSetOfAnotherArraySoln {

    static boolean IsSubset(int array1[], int array2[]){
        HashSet<Integer> setArray1 = new HashSet<>();
        for(int arr : array1){
            setArray1.add(arr);
        }
        //Loop to check if all elements of array2 also lie in array1
        for(int i =0; i<array2.length; i++){
            if(!setArray1.contains(array2[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] input1 = {
                {9, 4, 7, 1, -2, 6, 5},
                {34, 19},
                {1, 2, 5, 0, 7, 4, 23},
                {-4, 6, 8, 1, 3, 14, 5, 7, 29},
                {52, 57, 23, -6, 22, -16, 78, 98, 46, 24, 19},
        };

        int[][] input2 = {
                {7, 1, -2},
                {34},
                {},
                {14, -4, 29},
                {7, -6, 8, -4},
        };

        for (int i = 0; i < input1.length; i++) {
            System.out.println((i + 1) + ".\tArray1: " + Arrays.toString(input1[i]));
            System.out.println("\tArray2: " + Arrays.toString(input2[i]));
            System.out.println("\tResult: " + IsSubset(input1[i], input2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

