package Codility;

public class PermCheck {
    public static int solution(int[] A){
        int n = A.length;
        int[] count = new int[n+1];
        int maxValue = 0;
        for(int i =0; i<n; i++){
            if(A[i] <1 || A[i]>n){
                return 0;
            }
            if(A[i]>maxValue){
                maxValue = A[i];
            }
            count[A[i]]++;
            if(count[A[i]] >1){
                return 0;
            }
        }
        if(maxValue != n){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,3,2}));
    }
}
