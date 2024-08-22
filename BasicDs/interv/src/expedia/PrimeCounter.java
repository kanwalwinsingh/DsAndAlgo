package expedia;

import java.util.Arrays;

public class PrimeCounter {
    public static int countPrimes(int n){
        if(n<2){
            return 0;
        }
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false; // o is not orime
        isPrime[1] = false; // 1 is not prime

        //Sieve of Erasthone
        for(int i = 2; i*i <= n; i++){
            if(isPrime[i]){
                for (int j = i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of primes
        int primeCount = 0;
        for(int i = 2; i<=n;i++){
            if(isPrime[i]){
                primeCount++;
            }
        }
        return primeCount;
    }
    public static void main(String[] args) {
        int n = 10;
        int numberOfPrimes = countPrimes(n);
        System.out.println("Number of primes less than or equal to " + n + " is: " + numberOfPrimes);
    }
}
