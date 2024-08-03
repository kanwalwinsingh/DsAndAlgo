package NAB;
/*
You are given an array A consisting of N integers within the range [1..N]. In one move, you can increase or decrease the value of any element by 1. After each move, all numbers should remain within the range (1.N).
Your task is to find the smallest required number of moves to make all elements in the array pairwise distinct (in other words, no value can appear in the array more than once).
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the smallest number of moves required to make all elements in the array pairwise distinct. If the result is greater than 1,000,000,000, the function should return -1.
Examples:
1. Given A = [1, 2, 1], the function should return 2, because you can increase A 2]
twice: [1, 2, 11 → 1, 2, 2 →> [1, 2, 3). In this example, you could also change the array to the following values in two moves: [3, 2, 11, [1, 3, 2), [2, 3, 1].
2 Given A = [2, 1, 4, 4], the function should return 1, as it is-sufficient to decrease
A|2 or Al3) by 1, resulting in [2, 1, 3, 4] or [2, 1, 4, 3].
3. Given A = [6, 2, 3, 5, 6, 3), the function should return 4, because you can achieve
the following array in four moves: [6, 2, 1, 5, 4, 3).
Write an efficient algorithm for the following assumptions:
• Nis an integer within the range [1..200,000);
• each element of array A is an integer within the range (1..N).
 */

import java.util.Arrays;

//https://www.chegg.com/homework-help/questions-and-answers/given-array-consisting-n-integers-within-range-1n--one-move-increase-decrease-value-elemen-q121018756
public class IncrementOrDecremnetValueOfFieldByOneInArray {
    public static int solution(int[] A){
      //Get the length of the input Array A
      int n = A.length;

      //Check if the input constraints exceed the given limit
        if(n>2_00_000 || Arrays.stream(A).max().getAsInt() > n){
            return -1;
        }

        //Initialize the variable to keep track of the number of moves required
        int moves =0;
        //Create an array to count occurence of each number (initialized with 0)
        int[] counts = new int[n+1];

        //Iterate through the input array A
        for(int num : A){
            //If the number has not been encountered before
            if(counts[num] == 0){
                counts[num] = 1; //Mark it as encountered
            }else{
                int distance = 0;
                //Find the nearest available number below 'num'
                while (num-distance > 0 && counts[num-distance] >0){
                    distance++;
                }
                if(num-distance >0){
                    counts[num-distance] = 1; //Mark the new number as encountered
                    moves+=distance; // Update the total moves
                }else{
                    // Find the nearest available number above 'num'
                    int i = num+1;
                    while (counts[i]>0){
                        i++;
                    }
                    counts[i] = 1; // Mark the new number as encountered
                    moves+= i-num; // update the total moves
                }
            }

        }
        //Return the total moves
        return moves;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,2,1}));
        System.out.println(solution(new int[]{2, 1, 4, 4}));
        System.out.println(solution(new int[]{6, 2, 3, 5, 6, 3}));
    }
}
