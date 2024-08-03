package Codility;

import java.util.Arrays;

public class IntersectionofTwoDisc {
    /*  First we create two arrays of starting points (where a disc intersects
    with x-axe on the left) ane ending points (where a disc intersects with
    x-axe on the right). Then we sort theese arrays, so we don't depend on
    radiuses or centers.
    Then we iterate through both arrays and add intersections of lower end
    and substract already proceeded starting ends to avoid double counting
    intersections
*/
    public static int solution(int[] A){
        int n = A.length;
        long[] A1 = new long[n];
        long[] A2 = new long[n];
        for(int i =0; i<n; i++){
            A1[i] = i - (long)A[i];
            A2[i] = i+(long)A[i];
        }
        Arrays.sort(A1);
        Arrays.sort(A2);

        long intersectCount = 0;
        int j =0;
        for(int i =0; i<n; i++){
            while (j<n && A2[i] >= A1[j]){
                intersectCount +=j;
                intersectCount -=i;
                j++;
            }
        }
        if(intersectCount > 10000000){
            intersectCount = -1;
        }
        return (int) intersectCount;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 1, 4, 0}));
    }
}
