package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MininimumAbsDistance {
    public static List<List<Integer>> minimumAbsDistance(int[] arr){
        //Step 1 : Sort the array
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        //Step 2: find the minimum abs distance
        for(int i = 1; i< arr.length; i++){
            int diff = arr[i] -arr[i-1];
            minDiff = Math.min(minDiff,diff);
        }

        //Step 3: collect all pairs with the minimum difference
        for(int i =1; i<arr.length; i++){
            int diff = arr[i]-arr[i-1];
            if(diff == minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> pairs = minimumAbsDistance(arr);
        System.out.println(pairs);  // Expected output: [[1, 2], [2, 3], [3, 4]]
    }
}
