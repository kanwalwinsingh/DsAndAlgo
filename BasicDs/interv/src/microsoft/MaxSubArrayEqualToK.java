package microsoft;

import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 * Input: arr[] = { 10, 5, 2, 7, 1, 9 }, k = 15
 * Output: 4
 * Explanation: The sub-array is {5, 2, 7, 1}.
 *
 * Input: arr[] = {-5, 8, -14, 2, 4, 12}, k = -5
 * Output: 5
 */
public class MaxSubArrayEqualToK  {
    public static int longestSubArrayWithK(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxlength = 0;
        for(int i = 0; i<arr.length; i++){
            sum+= arr[i];
            if(sum == k) {
                maxlength = i + 1;
            }
            if (map.containsKey(sum-k)){
                maxlength = Math.max(maxlength, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxlength;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println("Length of the longest sub-array is " + longestSubArrayWithK(arr, k)); // Output: 4
    }
}
