package Codility;


import java.util.Arrays;

public class FindATriangleInArrayValues {
    /*  First we sort the array.
       A candidate for a triangle should have as little difference
       between length of its edges as possible. So we iterate through
       the array, checking if any 3 consecutive elements satisfy the
       condition of a triangle */
    public static int Solution(int[] A){
        Arrays.sort(A);
        for(int i =0; i<A.length-2;i++){
            if((long)(A[i]+A[i+1])>(long)(A[i+2])){
                return 1;
            }
        }
        return 0;
    }

}
