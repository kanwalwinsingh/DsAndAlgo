package Codility;

public class CountDivisibleByK {
    public static int solution(int A, int B, int K){
        if(B == 0){
            return 1;
        }
        return (B/K) -((A==0) ?-1 : (A-1)/K );
    }

    public static void main(String[] args) {
        System.out.println(solution(6,11,2));
    }
}
