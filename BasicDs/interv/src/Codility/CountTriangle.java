package Codility;

import java.util.Arrays;

public class CountTriangle {
    public static int solution(int[] A){
        int n = A.length;
        if(n<3){
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        int result = 0;
        for(int i = 0; i< n-2; i++){
            int k = i+2;
            for(int j = i+1; j<n-1; j++){
                while (k<n && A[i]+A[j]>A[k]){
                    k++;
                }
                count+=k-j-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A  = {10,2,5,1,8,12};
        System.out.println(solution(A));
    }
}
