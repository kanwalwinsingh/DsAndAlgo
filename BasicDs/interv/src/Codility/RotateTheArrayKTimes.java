package Codility;

public class RotateTheArrayKTimes {

    public static int[] solution(int[] A, int K){
        int[] newArray = new int[K];
        int n = A.length;
        if(n == 0) {
            return A;
        }
        K = K % n;
        if(K>n){
            return A;
        }
        for (int i = n-K; i<n; i++){
            newArray[i-n+K] = A[i];
        }
        for(int i = n-K-1; i>=0; i--){
            A[i+K] = A[i];
        }
        for(int i =0; i<K; i++){
            A[i] = newArray[i];
        }
        return A;
    }
    public static void main(String args[]) {
        int n = 7;
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
        solution(arr, k);
        System.out.println("After Rotating the elements to right ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
