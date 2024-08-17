package agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballGoals {
    //Binary search to find the number of elments in teamA less than or equal to goalB
    private static int binarySearch(int[] teamA, int goalB){
        int low = 0, high = teamA.length;
        while (low < high){
            int mid = (low + high)/2;
            if(teamA[mid] <= goalB){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static List<Integer> getGoalsCount(int[] teamA, int[] teamB){
        //Sort teamA to enable binary Search
        Arrays.sort(teamA);
        List<Integer> result = new ArrayList<>();
        //For each goal in teamB, find the count of matches in teamA
        for(int goalB : teamB){
            // use binary search to find the rightmost index where teamA[i] <= goalB
            int count = binarySearch(teamA, goalB);
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] teamA = {1,2,3};
        int[] teamB = {2,4};

        List<Integer> result = getGoalsCount(teamA, teamB);
        System.out.println(result);
    }
}
