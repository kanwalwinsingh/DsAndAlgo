package Codility;

public class MinAvgTwoSlice {
    public static int solution(int[] A){
        double minAvg = (double) (A[0]+A[1])/2;
        int minAvgIndex = 0;
        int n = A.length;
        for(int i =0; i<n-1; i++){
            double  avg = (double) (A[i]+A[i+1])/2;
            if(minAvg>avg){
                minAvg = avg;
                minAvgIndex = i;
            }
        }
        for(int j =0; j<n-2; j++){
            double avg = (double) (A[j]+A[j+1]+A[j+2])/3;
            if(minAvg>avg){
                minAvg = avg;
                minAvgIndex = j;
            }
        }
        return minAvgIndex;
    }
}
