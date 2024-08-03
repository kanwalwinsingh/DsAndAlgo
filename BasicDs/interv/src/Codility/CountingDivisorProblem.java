package Codility;

public class CountingDivisorProblem {
    public static int countDivisors(int n){
        int count = 0;
        for(int i = 1; i*i <= n; i++){
            if(n%i == 0){
                if(i*i == n){
                    // if divisors are equal count only 1
                }else{
                    count+=2; // otherwise count both
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 24;
        System.out.println("Number of divisors of " + n + " is: " + countDivisors(n)); // Output: 8
     }
}
