package Codility;

public class MaxDoubleSlice {
    /*  We use Kadane's Algorithm in 2 directions:
       forward and reverse */
    public static int solution(int[] A){
        int n = A.length;
        int[] maxSumStart = new int[n];
        int [] maxSumEnd = new int[n];
        for(int i =1, j =n-2; i<n-1; i++,j--){
            maxSumEnd[i] = Math.max(0,maxSumEnd[i-1]+A[i]);
            maxSumStart[j] = Math.max(0,maxSumStart[j+1]+A[j]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i<n-1; i++){
            maxSum = Math.max(maxSum,maxSumEnd[i-1]+maxSumStart[i+1]);
        }
        return maxSum;
        }

    public static void main(String[] args) {
        int[] A = {3,2,6,-1,4,5,-1,2};
        System.out.println(solution(A));
    }
    }

