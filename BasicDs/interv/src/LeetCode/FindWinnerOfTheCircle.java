package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWinnerOfTheCircle {
    public static void main(String[] args) {
        System.out.println(findTheWinnerA(5,2));
    }

    public static int findTheWinner(int n, int k) {
        return josephus(n,k)+1;

    }
    private static int josephus(int n, int k){
        if(n==1){
            return 0;
        }else{
            return (josephus(n-1,k)+k)%n;
        }

    }

    public static int findTheWinnerA(int n, int k){
        List<Integer> participtant = new ArrayList<>(n);
        for(int i = 1; i<=n; i++){
            participtant.add(i);
        }
        int currentIndex = 0;
        while (participtant.size() >1){
            currentIndex = (currentIndex+k -1)%participtant.size();
            participtant.remove(currentIndex);
        }
        return participtant.get(0);

    }

}
