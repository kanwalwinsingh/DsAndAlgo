package agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
    public static int[] mergeAndRemoveDuplicates(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prev = Integer.MIN_VALUE; // Track the last added element

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (arr1[i] != prev) {
                    resultList.add(arr1[i]);
                    prev = arr1[i];
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (arr2[j] != prev) {
                    resultList.add(arr2[j]);
                    prev = arr2[j];
                }
                j++;
            } else {
                if (arr1[i] != prev) {
                    resultList.add(arr1[i]);
                    prev = arr1[i];
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.length) {
            if (arr1[i] != prev) {
                resultList.add(arr1[i]);
                prev = arr1[i];
            }
            i++;
        }

        // Add remaining elements from arr2
        while (j < arr2.length) {
            if (arr2[i] != prev) {
                resultList.add(arr2[j]);
                prev = arr2[j];
            }
            j++;
        }

        int[] result =  new int[resultList.size()];
        for(i =0; i< resultList.size(); i++){
            result[i]  = resultList.get(i);
        }
        return result;

    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        int[] mergedArray = mergeAndRemoveDuplicates(arr1, arr2);

        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
