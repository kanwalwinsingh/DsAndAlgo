package Gaana;

import java.util.HashMap;
import java.util.Map;

public class FindPairs {
    public static void findPairsWithGivenSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int targetSum = arr[i];
            Map<Integer, Integer> map = new HashMap<>();
            System.out.println("Target Sum at index " + i + ": " + targetSum);

            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue; // Skip the current index
                int complement = targetSum - arr[j];
                if (map.containsKey(complement)) {
                    System.out.println("Pair found: (" + arr[j] + ", " + complement + ") for target sum " + targetSum);
                }
                map.put(arr[j], j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        findPairsWithGivenSum(arr);
    }
}