package main.java.algorithms.divideandconquer;

import java.util.Arrays;

public class InversionCount {

    public static int InvCountBruteForce(int[] arr){
        int size = arr.length;
        int count = 0;
        for(int i =0; i< size-1; i++){
            for (int j = i+1; j<size; j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }



    public static int countInversionUtil(int arr[], int left, int right, int[] temp){
        int mid, invCount = 0;
        if(right>left) {
            mid = (left + right) / 2;
            //Inversion count is the sum of inversion in left-part + right-part + number of inversion in merge
            invCount = countInversionUtil(arr, left, mid, temp);
            invCount += countInversionUtil(arr, mid + 1, right, temp);
            //Merge both parts
            invCount += merge(arr, left, mid + 1,right, temp);
        }
        return invCount;
    }

    public static int merge(int[] arr, int left,int mid, int right, int[] temp){
        int invCount = 0;
        int i = left; // for left subarray
        int j = mid; // for ight subarray
        int k = left; // for resultant merged subarray
        while ((i<=mid-1) && (j<=right)){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                invCount = invCount + (mid-1);
            }
        }
        return invCount;
    }
    public static int countInversions(int arr[]) {

        int size = arr.length;
        int temp[] = new int[size];
        return countInversionUtil(arr, 0, size - 1,temp);
    }

    public static void main(String[] args) {
        int[] arr = {
                3,
                2,
                8,
                4
        };
        System.out.println(Arrays.toString(arr) + "  --->  " + countInversions(arr));
    }
}
