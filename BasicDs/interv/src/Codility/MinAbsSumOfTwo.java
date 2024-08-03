package Codility;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public static int solution(int[] A){
        int n = A.length;
        int left = 0;
        int right = 0;
        int minSum = Integer.MAX_VALUE;
        while (left<n && right<n){
            int sum = Math.abs(A[left]+A[right]);
            if(sum<minSum){
                minSum = sum;
            }
            right++;
            if(right == n){
                left++;
                right = left;
            }
        }
        return minSum;
    }

    public static int optimalSoln(int[] A){
        int N = A.length;
        Arrays.sort(A);
        int tail = 0;
        int head = N-1;
        int minAbsSum = Math.abs(A[tail]+A[head]);
        while (tail<=head){
            int currentSum = A[tail]+A[head];
            minAbsSum = Math.min(minAbsSum,Math.abs(currentSum));
            if(currentSum<=0){
                tail++;
            }else{
                head--;
            }
        }
        return minAbsSum;
    }

    public static void main(String[] args) {
        int[] A = {1,4,-3};
        System.out.println(optimalSoln(A));
    }
}
