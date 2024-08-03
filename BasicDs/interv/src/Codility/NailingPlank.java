package Codility;

public class NailingPlank {

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8};
        int[] B = {4, 5, 9, 10};
        int[] C = {4, 6, 7, 10, 2};

        int result = solution(A, B, C);
        System.out.println("Minimum number of nails: " + result); // Expected output: 4
    }

    public static int solution(int[] A, int[] B, int[] C){
        int min = 1;
        int max = C.length;
        int result = -1;

        while (min<=max){
            int mid = (min+max)/2;
            if(canNaillAlllPlanks(A,B,C,mid)){
                max = mid-1;
                result = mid;
            }else{
                min = mid+1;
            }
        }
        return result;
    }
    public static boolean canNaillAlllPlanks(int[] A, int[] B, int[] C, int numOfNails){
        int maxPosition = 2*C.length;
        int[] nails = new int[maxPosition+1];

        //mark the position of the first nail
        for(int i =0; i<numOfNails; i++){
            nails[C[i]] = 1;
        }

        //Compute the prefix sum array
        for(int i =1; i<=maxPosition; i++){
            nails[i] += nails[i-1];
        }

        //Check if each plank is nailed by any of the first numNails nails
        for(int i = 0; i<A.length; i++){
            if (nails[B[i]] - nails[A[i] - 1] == 0){
                return false;
            }
        }
        return true;
    }
}
