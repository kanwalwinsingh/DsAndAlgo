package Codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {
    public static int[] solutionBruteForce(int[] A){
        int n = A.length;
        int[] result = new int[n];
        int counter = 0;
        for (int i =0; i < n; i++){
            for(int j = 0; j< n; j++){
                if(i != j){
                    if(A[i] % A[j] != 0){
                        counter++;
                    }
                }
            }

            result[i] = counter;
            counter = 0;
        }
        return result;
    }

    /**
     * Use a hash map to count the frequency of each element in the array.
     * For each element, find its divisors up to its square root.
     * Use the frequency map to count the total number of divisors for each element.
     * Subtract the total number of divisors from the length of the array to get the count of non-divisors.
     * @param A
     * @return
     */
    public static int[] solution(int[] A){
        int n = A.length;
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int num : A){
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }

        int[] nonDivisors = new int[n];
        for(int i =0; i<n; i++){
            int num = A[i];
            int divisorCount = 0;
            for(int j =1; j*j<= num; j++){
                if(num%j == 0){
                    if(frequency.containsKey(j)){
                        divisorCount +=frequency.get(j);
                    }
                    if(j !=num/j  && frequency.containsKey(num/j)){
                        divisorCount += frequency.get(num/j);
                    }
                }
            }
            nonDivisors[i] = n-divisorCount;
        }
        return nonDivisors;
    }

    // this is the optimal solution
    public static int[] solutionArr(int[] A){
        int n = A.length;
        int[] frequency = new int[2*n+1];
        for(int num : A){
            frequency[num]++;
        }

        int[] nonDivisors = new int[n];
        for(int i =0; i<n; i++){
            int num = A[i];
            int divisorCount = 0;
            for(int j =1; j*j<= num; j++){
                if(num%j == 0){
                    if(frequency[j] != 0){
                        divisorCount +=frequency[j];
                    }
                    if(j !=num/j  && frequency[num/j]!= 0){
                        divisorCount += frequency[num/j];
                    }
                }
            }
            nonDivisors[i] = n-divisorCount;
        }
        return nonDivisors;
    }



    public static void main(String[] args) {
        CountNonDivisible c = null;
        int[] A = {3,1,2,5,3,6};
        int[] result = solutionArr(A);
        Arrays.stream(result).forEach(System.out::print);
    }
}
