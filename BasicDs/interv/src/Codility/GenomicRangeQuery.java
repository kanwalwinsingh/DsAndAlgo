package Codility;

import java.util.Arrays;

public class GenomicRangeQuery {
    public static int[] solution(String S, int[] P, int[] Q){
        int n = S.length();
        int[] impactArray = new int[n];
        int lastMin = Integer.MAX_VALUE;
        for(int i =0; i<S.length(); i++){
            Character ch = S.charAt(i);
            switch (ch){
                case 'A':
                    impactArray[i] =1;
                    break;
                case 'C':
                    impactArray[i] =2;
                    break;
                case 'G':
                    impactArray[i] =3;
                    break;
                case 'T':
                    impactArray[i] =4;
                    break;
            }
        }
        int pLen = P.length;
        int qLen = Q.length;
        if(pLen != qLen){
            return new int[]{};
        }
        int[] result = new int[pLen];
        for(int j =0; j< pLen; j++){
            result[j] = minImpact(impactArray,P[j],Q[j]);
        }
        return result;
    }
    public static int minImpact(int[] impact, int p, int q){
        int min = Integer.MAX_VALUE;
        for(int i =p; i<=q; i++){
            if(impact[i]<min){
                min = impact[i];
            }
        }
        return min;
    }

    public static int[] optimalSolution(String S, int[] P, int[] Q){
        int len = S.length();
        int[][] prefixSum = new int[4][len+1];
        int sumA =0, sumC =0, sumG =0, sumT =0;
        for(int i =1; i< len+1; i++){
            switch (S.charAt(i-1)){
                case 'A': sumA++; break;
                case 'C': sumC++;break;
                case 'G': sumG++; break;
                case 'T': sumT++; break;
            }
            prefixSum[0][i] = sumA;
            prefixSum[1][i] = sumC;
            prefixSum[2][i] = sumG;
            prefixSum[3][i] = sumT;
        }
        int m = Math.min(P.length, Q.length);
        int[] result = new int[m];
        int min,max;
        for (int i =0; i<m; i++){
            min = P[i];
            max = Q[i]+1;
            if(prefixSum[0][max] - prefixSum[0][min] >0){
                result[i] = 1;
            }else if(prefixSum[1][max]-prefixSum[1][min]>0){
                result[i] = 2;
            } else if (prefixSum[2][max]- prefixSum[2][min]>0) {
                result[i] = 3;
            } else{
                result[i] = 4;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(optimalSolution("CAGCCTA", new int[]{2,5,0},new int[]{4,5,6})));
    }
}
