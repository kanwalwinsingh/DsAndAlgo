package Codility;

public class FactorOfNNumbers {
    public static int solution(int N){
        long n = N;
        long i, counter = 0;
        for(i = 1; i*i <n; i++){
            if(n%i == 0){
                counter+=2;
            }
        }
        if(i*i == n){
            counter++;
        }
        return (int) counter;
    }
}
