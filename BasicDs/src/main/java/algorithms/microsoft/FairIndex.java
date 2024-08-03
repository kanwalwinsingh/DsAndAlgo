package main.java.algorithms.microsoft;

public class FairIndex {
    public static int fairIndex(int a[], int b[]){
        int sumA = 0;
        int sumB = 0;
        for(int i =0; i< a.length; i++){
            sumA +=a[i];
            sumB +=b[i];
        }
        int count = 0;
        int tempA = a[0];
        int tempB = b[0];
        for(int i =1; i<a.length; i++){
            if(tempA == tempB && 2*tempA == sumA && 2*tempB == sumB) {
                count++;
            }
            tempA +=a[i];
            tempB += b[i];
        }
        return count;


    }

    public static void main(String[] args) {
        int[] A1 = {3,0,4,-1};
        int[] B1 = {3,0,-2,5};
        System.out.println(fairIndex(A1, B1));
    }
}
