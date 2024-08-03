package Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSemiprimes {

    public static int countSemiprimesInRange(int a, int b) {
        List<Integer> primes = sieveOfEratosthenes(b/2);
        int count = 0;

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                int semiprime = primes.get(i) * primes.get(j);
                if (semiprime >= a && semiprime <= b) {
                    count++;
                } else if (semiprime > b) {
                    break;
                }
            }
        }
        return count;
    }

    // Function to perform the Sieve of Eratosthenes and return all primes up to n
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor * factor; j <= n; j += factor) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static int[] solution(int N, int[] P, int[] Q){
        int[] result = new int[P.length];
        for (int i =0; i<P.length; i++){
            result[i] = countSemiprimesInRange(P[i],Q[i]);
        }
        return result;
    }


    public static int[] optimizedSolution(int N, int[] P, int[] Q){
        // main idea:
        // using "sieve of Eratosthenes"
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

        boolean[] primeArray = new boolean[N + 1]; // note: plus one for "0"

        // initial settting (sieve of Eratosthenes)
        Arrays.fill(primeArray, true); // initial setting: all primes
        primeArray[0] = false; // not prime
        primeArray[1] = false; // not prime
        int sqrtN = (int) Math.sqrt(N);
        // sieve of Eratosthenes
        for (int i = 2; i < sqrtN; i++) {
            int j = i + i;
            for (j = j; j <= N; j = j + i) {
                primeArray[j] = false; // not prime
            }
        }

        // store all primes in "List"
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (primeArray[i] == true) {
                primeList.add(i); // "i" is prime
            }
        }

        // find "semiprimes"
        boolean[] semiprimeArray = new boolean[N + 1]; // note: plus one for "0"
        Arrays.fill(semiprimeArray, false); // initial setting: all "not" semiprimes
        long semiprimeTemp; // using "long" (be careful)
        // for "primeList.size()"
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {
                semiprimeTemp = (long) primeList.get(i) * (long) primeList.get(j); // semiprimes
                if (semiprimeTemp > N) {
                    break;
                } else {
                    semiprimeArray[(int) semiprimeTemp] = true; // semiprimes
                }
            }
        }

        // compute "cumulative Count of semiprimes"
        int[] semiprimeCumulateCount = new int[N + 1]; // note: plus one for "0"
        for (int i = 1; i <= N; i++) {
            semiprimeCumulateCount[i] = semiprimeCumulateCount[i - 1]; // cumulative
            if (semiprimeArray[i] == true) {
                semiprimeCumulateCount[i]++; // semiprimes
            }
        }

        // compute "results" (for each query)
        int numQuery = Q.length;
        int[] result = new int[numQuery];
        for (int i = 0; i < numQuery; i++) {
            result[i] = semiprimeCumulateCount[Q[i]] - semiprimeCumulateCount[P[i] - 1]; // note: "P[i]-1" (not
            // included)
        }
        return result;

    }

    public static void main(String[] args) {
        int[] P = {1,4,16};
        int[] Q  = {26,10,20};
        Arrays.stream(optimizedSolution(26,P,Q)).boxed().forEach(System.out::println);
    }
}
