package Codility;

import java.util.HashMap;
import java.util.Map;

public class FindSingleOccuranceOfNumber {
    public static int solution(int[] A){
        int n = A.length;
        Map<Integer,Integer> myMap = new HashMap<>();
        for (int i =0; i<n; i++){
            int num = A[i];
            if(myMap.containsKey(num)){
                myMap.put(num,myMap.get(num)+1);
            }else {
                myMap.put(num,1);
            }
        }
        for (Integer key: myMap.keySet()){
            if(myMap.get(key).equals(1)){
                return key;
            }
        }
        return -1;
    }

    public static int solutionusingXor(int[] A){
        int res = A[0];
        for (int i =1; i<A.length;i++){
            res = res ^ A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solutionusingXor(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}
