package main.java.algorithms.searching.binarysearch.countoccuranceinarray;

import main.java.algorithms.searching.binarysearch.BinarySearch;

public class CountOccuranceOfKInBinarSearch {

    //BruteForce
    public static int calcFreq(int arr[], int key){
        int count = 0;
        // traversing the array
        for(int i =0; i< arr.length; i++){
            //checking if current index value matches key
            if(arr[i] == key){
                count++;
            }
        }
        return count;
    }

    //using Binary Search complexity O(logn+count)
    public static int calcFreqBinarySearch(int[] arr, int key){
        int arrSize = arr.length;
        int index = BinarySearch.binarySearch(key,arr,arrSize);
        if(index == -1){
            return 0; // element not found
        }
        int count = 1; // Initialize a count

        int start = index-1; // counting the on present in the left
        while (start>=0 && arr[start] == key){
            count++;
            start--; // Decrement the start index if found
        }

        int end = index+1; // counting the one present in the right
        while (end< arrSize && arr[end] == key){
            count++;
            end++; // Increment the end Index if found
        }
        return count;
    }

    // modified binarySearch
    public static int calcFreqModifiedBinarySearch(int arr[], int key) {
        // finding the index of the first occurance
        int arrSize = arr.length;
        int start = 0, end = arrSize-1, mid =0, result = -1;
        while (start<=end){
            mid = (start+end)/2;
            if(arr[mid] == key){
                result = mid;
                end = mid-1;
            } else if (arr[mid]>key) {
                end = mid-1;
            } else if (arr[mid]<key) {
                start = mid+1;
            }
        }

        //finding the index of the second occurrence
        int start1 = 0, end1 = arrSize-1, mid1, result1 = -1;
        while (start1<end1){
            mid1 = (start1+end1)/2;
            if(arr[mid1] == key){
                result1 = mid1;
                start1 = mid1+1;
            } else if (arr[mid1]> key) {
                end1 = mid1-1;
            } else if (arr[mid1]<key) {
                start1 = mid1+1;
            }
        }
        //If one of them is not found, return their difference
        if(result1 == -1 || result == -1){
            return (result1-result);
        }else{
            return (result1-result +1);
        }


    }



    public static void main(String args[])
    {
        int arr[] = {-5,-3,0,1,3,3,3,3,4,5};
        int key = 3;
        System.out.println("The key \""+ key + "\" occurs " + calcFreqModifiedBinarySearch(arr, key) + " times in the Array.");
    }

}
