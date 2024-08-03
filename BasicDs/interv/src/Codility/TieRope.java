package Codility;

import java.util.Arrays;

public class TieRope {
    public static int solution(int K,int[] A){
        int count = 0;
        int currentLength = 0;
        for(int length : A){
            currentLength+= length;
            if(currentLength >= K){
                count++;
                currentLength = 0;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int K = 4;
        int[] A = {1, 2, 3, 4, 1, 1, 3};

        int result = solution(K, A);
        System.out.println("Maximum number of ropes of length >= " + K + ": " + result); // Expected output: 3
    }
}
