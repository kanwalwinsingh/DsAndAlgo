package main.java.algorithms.divideandconquer;

import java.util.Arrays;

public class FloorAndCielingOfNumber {
    public static int findFloor(int[] arr, int x) //Function to find the floor of x
    {
        int left = 0, right = arr.length-1;
        int floor =-1; //
        while (left<= right){
            int mid = (left+right)/2;
            if(arr[mid] == x){
                return arr[mid];
            } else if (arr[mid]>x){
                    right = mid -1;
            }else {
                floor = arr[mid];
                left = mid+1;
            }
        }
        return floor;
    }
    public static int findCieling(int[] arr, int x){
        int left = 0, right = arr.length-1;
        int cieling = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == x){
                return arr[mid];
            }else if(arr[mid]>x){
                cieling = arr[mid];
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return cieling;
    }

    public static void findFloor_Ciel(int[] input, int x, int[] output){
        output[0] = findFloor(input,x);
        output[1] = findCieling(input,x);
    }
    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 5, 7};
        int[] output = new int[2];
        findFloor_Ciel(inputs, 4, output);
        System.out.println("Floor and Ceil of 4 is: " + Arrays.toString(output));

    }
}
