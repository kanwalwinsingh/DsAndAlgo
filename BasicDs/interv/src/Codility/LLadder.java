package Codility;

import java.util.Arrays;

public class LLadder {

    public static int fibonaci(int n){
        int[] fib = new int[n<2? 2: n+1];
        fib[0] = 1;
        fib[1] = 2;
        int fs = 2;
        while (fib[fs-1]<n+1){
            fib[fs] = fib[fs-1]+fib[fs-2];
            fs++;
        }
        return fib[n-1];
    }

    public static int[] solution(int[] L, int[] P){
        int N = L.length;
        int maxL = Arrays.stream(L).max().getAsInt();

        // Step 1: Compute Fibonacci numbers up to maxL
        int[] fib = new int[maxL + 2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= maxL + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // Step 2: Compute the number of ways for each ladder
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = fib[L[i]+1] % (1 << P[i]);
        }

        return result;
    }

    public  static int[] solutionOptimal(int[] A, int[] B){
        int L = A.length;
        int[] fib = new int[L + 2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= L; i++) {
            // make sure the fibonacci number will not exceed the max integer in java 1<<n =
            // 2^n
            fib[i] = (fib[i - 1] + fib[i - 2]) % (1 << 30);
        }
        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int A[] = {4,4,5,5,1};
        int B[] = {3,2,4,3,1};
        Arrays.stream(solutionOptimal(A,B)).boxed().forEach(System.out::println);
    }
}
