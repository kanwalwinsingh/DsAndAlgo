package Codility;

import java.util.Arrays;

public class DistinctInInteger {
    public static int solution(int[] A){
       return (int) Arrays.stream(A).boxed().distinct().count();

       //Another way
      // return Arrays.stream(A).boxed().collect(Collectors.toSet()).size();

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,1,2,3,1}));
    }
}
