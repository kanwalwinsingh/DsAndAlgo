package Codility;

public class MaxNonOverllappingSegment {
    public static void main(String[] args) {
        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};

        int result = solution(A, B);
        System.out.println("Maximal set of non-overlapping segments: " + result); // Expected output: 3
    }

    public static int solution(int[] A, int[] B){
        int n = A.length;
        if(n == 0){
            return 0;
        }
        //Initalize count of non-overlapping segments
        int count = 1;
        //The endpoint of last selected segment
        int lastEnd = B[0];
        for(int i = 0; i< n; i++){
            if(A[i]>lastEnd){
                count++;
                lastEnd = B[i];
            }
        }
        return count;
    }
}
