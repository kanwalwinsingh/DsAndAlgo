package Codility;

public class MaxSliceSum {
    public static int solution(int[] A){
        int n = A.length;
        int max_ending = 0, max_slice = Integer.MIN_VALUE;
        for (int i =0; i<n; i++){
            max_ending = Math.max(A[i], max_ending+A[i]);
            max_slice = Math.max(max_ending,max_slice);
        }
        return max_slice;
    }
}
