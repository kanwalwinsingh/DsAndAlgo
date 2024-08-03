package Codility;
//This is based on the algo of the prefix sum
public class MushroomPicker {

    public static int[] prefixSums(int[] A){
        int n = A.length;
        int[] P = new int[n+1];
        for(int k = 1; k<= n; k++){
            P[k] = P[k-1]+A[k-1];
        }
        return P;
    }

    public static int countTotal(int[] P, int x, int y){
        return P[y+1] - P[x];
    }

    public static int mushrooms(int[] A, int k, int m){
        int n = A.length;
        int result = 0;
        int[] pref = prefixSums(A);
        //Move to the left then to the right
        for (int p = 0; p<=Math.min(m,k);p++){
            int leftPos = k-p;
            int rightPos = Math.min(n-1, Math.max(k,k+m-2*p));
            result = Math.max(result,countTotal(pref,leftPos,rightPos));
        }
        //Move to the right then to the left
        for (int p = 0; p<=Math.min(m,n-k-1);p++){
            int rightPos = k+p;
            int leftPos = Math.max(0, Math.max(k,k-(m-2*p)));
            result = Math.max(result,countTotal(pref,leftPos,rightPos));
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {2, 3, 7, 5, 1, 3, 9};
        int k = 4;
        int m = 6;
        System.out.println(mushrooms(A, k, m)); // Output: 25
    }
}
