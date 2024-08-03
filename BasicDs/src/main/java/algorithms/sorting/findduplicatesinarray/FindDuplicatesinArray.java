package main.java.algorithms.sorting.findduplicatesinarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesinArray {
    public static ArrayList<Integer> findDuplicates(int[] arr){
        ArrayList<Integer> duplicates = new ArrayList<>();
        int n= arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        boolean dup = false;
        for (int i =0; i< n; i++){
            if(map.containsKey(arr[i])){
                count  = map.get(arr[i])+1;
                map.put(arr[i],count);
            }else {
                map.put(arr[i],1);
            }
        }
        int index =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                duplicates.add(entry.getKey());
                dup = true;
            }
        }
        return duplicates;
    }
    public static void main(String[] args) {
        int arr[] = {
                7,
                5,
                4,
                3,
                11,
                5,
                11,
                9,
                3,
                11
        };
        ArrayList < Integer > dupes = findDuplicates(arr);
        System.out.println("Duplicates in " + Arrays.toString(arr) + " are " + dupes);

        int arr1[] = {
                6,
                5,
                17
        };
        dupes = findDuplicates(arr1);
        System.out.println("Duplicates in " + Arrays.toString(arr1) + " are " + dupes);
    }
}
