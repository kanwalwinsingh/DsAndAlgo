package Codility;

import java.util.Arrays;

public class MaxCounter {
    public static int[] solution(int N, int[] A){
        int arrLength = A.length;
        int[] count  = new int[N];
        int max_counter  = 0;
        for(int i : A){
            int counterIndex = i-1;
            if(i >= N+1){
                Arrays.fill(count,max_counter);
            } else {
                count[counterIndex] = count[counterIndex]+1;
                if(max_counter<count[counterIndex]){
                    max_counter = count[counterIndex];
                }
            }
        }
        return count;
    }

    public static int[] solutionOptimized(int N, int[] A){
        int[] counters = new int[N];
        int max = 0, adjustMax = 0;
        for(int i : A){
            if(i>N){
                adjustMax = max;
            }
            else {
                i--;
                if(counters[i] <adjustMax){
                    counters[i] = adjustMax +1;
                }else {
                    counters[i]++;
                }
                if(max< counters[i]){
                    max = counters[i];
                }
            }
        }
        for(int i =0; i<N; i++){
            if(counters[i]<adjustMax){
                counters[i] = adjustMax;
            }
        }
        return counters;
    }

    public static void main(String[] args) {
       int[] result =  solutionOptimized(5,new int[]{3,4,4,6,1,4,4});
        Arrays.stream(result).forEach(System.out::print);
    }
}
