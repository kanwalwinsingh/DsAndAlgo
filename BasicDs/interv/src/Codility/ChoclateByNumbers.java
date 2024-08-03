package Codility;

public class ChoclateByNumbers {
    public int solution(int N, int M){
        return N/gcdByDivison(N,M);
    }
    public static int gcdByDivison(int A, int B){
        if(A%B == 0)
            return B;
           return gcdByDivison(B, A%B);
    }

    public static void main(String[] args) {
        System.out.println(gcdByDivison(75,25));
    }
}
