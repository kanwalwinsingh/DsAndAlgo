package main.java.algorithms.searching.binarysearch.searchinspasedarrayofstring;

import java.util.Objects;

public class SearchSparsedArrayStringSoln {
    //Brute Force
    public static int searchForStringBruteForce(String[] array, String target){
        // traverse array
        for(int i =0; i< array.length;i++){
            //check if current value equals to target string
            if(array[i].equals(target)){
                //return the target index
                return i;
            }
        }
        return -1;
    }

    //BinarySearch
    public static int modifiedBinarySearch(String[] arr, int low, int high, String target){
        if(low>high){
            return -1;
        }
        // calculate mid value
        int mid = (low+high)/2;

        //Our modification
        if(Objects.equals(arr[mid], "")){
            int i = mid - 1;
            int j = mid + 1;
            while (true){
                if(i<low && j> high){
                    return -1;
                }
                if(i>=low && arr[i] != ""){
                    mid = i;
                    break;
                } else if(j<=high && arr[j] != ""){
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }

        // Now perform simle binary search
        if(arr[mid].equals(target))
            return mid;
        else if (arr[mid].compareTo(target) >0) {
            return modifiedBinarySearch(arr,low,mid-1,target);
        }else {
            return modifiedBinarySearch(arr,mid+1,high,target);
        }
    }

    public static int searchForString(String[] arr, String target){
        return modifiedBinarySearch(arr,0,arr.length,target);
    }


    public static void main(String args[])
    {
        String [] array = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
        String [] targetArray = {"educative", "learning"};

        for(int i = 0; i < 2; i++) {
            System.out.println(targetArray[i] + ": " + searchForString(array, targetArray[i]));
        }
    }
}
