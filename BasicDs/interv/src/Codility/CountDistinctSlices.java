package Codility;

public class CountDistinctSlices {
 public static int solution(int M, int[] A){
     int n = A.length;
     boolean[] seen = new boolean[M+1];
     int left = 0;
     int right = 0;
     int numSlices = 0;

     while (left<n && right<n){
         //case 1: distinct right end
         if(!seen[A[right]]){
             // note: not just +1 there could be (right-left +1) combinations
             numSlices = numSlices+(right-left+1);
             if(numSlices> 1_000_000_000){
                 return 1_000_000_000;
             }
             //increase the slice to right by 1
             seen[A[right]] = true;
             right++;
         }
         //case 2: non distinct
         else {
             //decrease the slice from left by 1 remove A[left] from seen
             seen[A[left]] =false;
             left++;
         }
     }
     return numSlices;
 }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a1 = { 3, 4, 5, 5, 2 };
        int a = 5;
        int result2 = solution(a, a1);
        System.out.println(result2);
    }
}
