package Codility;

public class MinPerimeterRectangle {
    public static int solution(int N){
        long n = N;
        long i = 1;
        long minValue = Long.MAX_VALUE;
        for(; i*i<=n; i++){
            if(n%i == 0){
                long secondDivisor = n/i;
                minValue = Math.min(minValue,2*(secondDivisor+i));
            }
        }
        return (int)minValue;
    }

    public static void main(String[] args) {
        System.out.println(solution(30));
    }
}
