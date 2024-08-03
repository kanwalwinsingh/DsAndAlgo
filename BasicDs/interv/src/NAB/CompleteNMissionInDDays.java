package NAB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * In order to finish a game, a player has to complete N missions. The missions are numbered from 0 to N-1. The K-th mission has an integer D[K] assigned, representing its difficulty level. During a day, you can perform any number of missions given the two following rules: • missions should be performed in the specified order, i.e. a mission can be undertaken only if all of the missions preceding it have already been completed; • the difference between the difficulty levels of any two missions performed on the same day should not be greater than an integer X. Write a function: class Solution public int solution (int[] a, int x):) that, given an array D of N integers and an integer X, returns the minimum number of days required to complete all of the missions in the game. Examples: 1. Given D = [5, 8, 2, 7) and X = 3, your function should return 3. The first two missions can be performed on the first day, the third mission on the second day and the last mission on the third day. It is not possible to complete all of the missions in fewer days. 2. Given D = (2, 5, 9, 2, 1, 4) and X = 4, your function should return 3. The first two missions can be performed on the first day, the third mission on the second day and all of the remaining missions on the third day. Note that it is possible to perform the first mission on the first day and the next two missions on the second day. In both of these cases, the minimum number of days required to complete all of the missions is 3. 3. Given D = [1,12, 10, 4, 5, 2) and X = 2, your function should return 4. The first mission can be performed on the first day, the next two missions on the second day, the fourth and fifth missions on the third day, and the last remaining mission on the fourth day. It is not possible to complete all of the missions in fewer days. Write an efficient algorithm for the following assumptions: • N is an integer within the range [1.200,000); X is an integer within the range (0.1,000,000,000); • each element of array D is an integer within the range
 */
public class CompleteNMissionInDDays {
    public static int solution(int[] D, int X){
        int N = D.length;
        if(N == 0){
            return 0;
        }
        //Initialize the day counter
        int days = 1;

        //List to keep track of the current day's difficulties
        List<Integer> currentDayDiffficulties = new ArrayList<>();
        currentDayDiffficulties.add(D[0]);
        //Iterate through each day mission starting from the second one
        for(int i =1; i<N; i++){
            int currentDifficulty = D[i];
            int minDif = Collections.min(currentDayDiffficulties);
            int maxDif = Collections.max(currentDayDiffficulties);

            //Check if the current mission can be added to the current day
            if(Math.abs(currentDifficulty-minDif)<=X && Math.abs(currentDifficulty-maxDif)<=X){
                currentDayDiffficulties.add(currentDifficulty);
            }else{
                //otherwise start a new day
                days++;
                currentDayDiffficulties.clear();
                currentDayDiffficulties.add(currentDifficulty);
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int[] D1 = {5, 8, 2, 7};
        int X1 = 3;
        System.out.println(solution(D1,X1));
        int[] D2 = {2, 5, 9, 2, 1, 4};
        int X2 = 4;
        System.out.println(solution(D2,X2));
        int[] D3 = {1,12, 10, 4, 5, 2};
        int X3 = 2;
        System.out.println(solution(D3,X3));
    }
}
