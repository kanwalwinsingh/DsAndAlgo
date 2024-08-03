package Codility;

public class FirstMissingElementInPositiveArray {
    public static int solution(int[] A) {
        int n = A.length;
        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += A[i];
        }
        n = n + 1;
        int sum = ((n) * (n + 1)) / 2;
        if (sum == arraySum) {
            return A.length + 1;
        } else {
            return sum - arraySum;
        }
    }

    //This is the real solution
    public static int SecondSolution(int[] A){
        int n = A.length;
        int xor1 = 0 , xor2 = 0;
        for(int i = 0; i< n; i++){
            xor1= xor1^A[i];
        }
        for(int i = 1; i<= n+1; i++){
            xor2= xor2^i;
        }
        return xor1^xor2;
    }

    public static void main(String[] args) {
        System.out.println(SecondSolution(new int[]{2,3,1,5}));
    }
}
