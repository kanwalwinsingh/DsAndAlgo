package Codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxDivision {
    public static int solution(int K, int M, int[] A){
       int min = 0;
       int max =0;
       for(int i =0; i<A.length; i++){
           max+=A[i];
           min = Math.max(min,A[i]);
       }
       int result = max;
       while (min<=max){
           int mid = (min+max)/2;
           System.out.println("mid: "+ mid);
           if(divisionSolvable(mid,K-1,A)){
               max = mid-1;
               result = mid;
           }else {
               min = mid+1;
           }
       }
       return result;
    }

    private static boolean divisionSolvable(int mid, int k, int[] a){
        int sum =0;
        for(int i =0; i< a.length; i++){
            sum+= a[i];
            if(sum > mid){
                sum = a[i];
                k--;
            }
            if(k<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    //    int[][] images ={{1,1,1},{1,1,0},{1,0,1}};
//        List<Integer> collect = Arrays.stream(images).flatMap(a -> Arrays.stream(a).boxed()).collect(Collectors.toList());
//        System.out.println();
        int[] a1 = { 2, 1, 5, 1, 2, 2, 2 };
        int result2 = solution(3, 5, a1);
        System.out.println(result2);
    }
}
