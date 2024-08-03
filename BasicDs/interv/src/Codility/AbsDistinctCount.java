package Codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbsDistinctCount {

    public static int solution(int[] A){;
        return (int) Arrays.stream(A).boxed().map(Math::abs).distinct().count();
//        Set<Integer> set = new HashSet<>();
//        for(Integer s : A){
//            set.add(Math.abs(s));
//        }
//        return set.size();

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5,-3,-1,0,3,6}));
    }

}
