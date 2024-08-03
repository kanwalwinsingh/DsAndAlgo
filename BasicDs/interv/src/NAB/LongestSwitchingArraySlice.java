package NAB;

import java.util.Arrays;

/**
 * An array is called "switching" if the odd and even elements are equal.
 *
 * Example:
 *
 * [2,4,2,4] is a switching array because the members in even positions (indexes 0 and 2) and odd positions (indexes 1 and 3) are equal.
 *
 * If A = [3,7,3,7, 2, 1, 2], the switching sub-arrays are:
 *
 * == > [3,7,3,7] and [2,1,2]
 *
 * Therefore, the longest switching sub-array is [3,7,3,7] with length = 4.
 *
 * As another example if A = [1,5,6,0,1,0], the the only switching sub-array is [0,1,0].
 *
 * Another example: A= [7,-5,-5,-5,7,-1,7], the switching sub-arrays are [7,-1,7] and [-5,-5,-5].
 *
 * Question:
 *
 * Write a function that receives an array and find its longest switching sub-array.
 */
public class LongestSwitchingArraySlice {
    //To optimize, we can use a sliding window approach to reduce the time complexity to
    //O(N). Here’s how you can implement it:
    public static int solution(int[] A){
        if(A == null || A.length == 0){
            //return new int[0];
            return 0;
        }

        int maxlength = 0;
        int bestStart = 0;
        int start = 0;
        while (start<A.length){
            int end = start;
            int evenValue = A[start];
            int oddValue = (start+1<A.length) ? A[start+1] :evenValue;
            while (end< A.length){
                if(end%2 == 0){
                    if(A[end] != evenValue) break;
                }else{
                    if(A[end] != oddValue) break;
                }
                end++;
            }
            int length = end-start;
            if(length>maxlength){
                maxlength = length;
                bestStart = start;
            }
            if(length == A.length){
                break;
            }
            start++;
        }
//        int[] result = new int[maxlength];
//        System.arraycopy(A, bestStart, result, 0, maxlength);
        return maxlength;
    }
    public static void main(String[] args) {
        int[] A1 = {3,2,3,2,3};
        System.out.println(solution(A1));
       // int[] result1 = solution(A1);
       // System.out.println(Arrays.toString(result1)); // Output: [3,2,3,2,3]

        int[] A2 = {7,4,-2,4,-2,-9};
        System.out.println(solution(A2));
       // int[] result2 = solution(A2);
       // System.out.println(Arrays.toString(result2)); // Output: [4,-2,4,-2]

        int[] A3 = {7, -5, -5, -5, 7, -1, 7};
        System.out.println(solution(A3));
       // int[] result3 = solution(A3);
       // System.out.println(Arrays.toString(result3)); // Output: [7, -1, 7] or [-5, -5, -5]
    }
}
