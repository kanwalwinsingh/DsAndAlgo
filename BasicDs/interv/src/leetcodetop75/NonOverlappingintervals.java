package leetcodetop75;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingintervals {
    public int eraseOverLappingIntervals(int[][] intervals){
        if(intervals.length == 0){
            return 0;
        }
        //Sort intervals by their end time
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);

        int removals = 0;
        int prevEnd = intervals[0][1];
        //Iterate through the intrvals starting from the second one
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                // If the current intervals start before the previous end, we have an overlap
                removals++;
            }else{
                //Otherwise, update the end time to the current intervals end time
                prevEnd = intervals[i][1];
            }
        }
        return removals;
    }
    // Driver code to test the solution
    public static void main(String[] args) {
        NonOverlappingintervals solution = new NonOverlappingintervals();

        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("Minimum removals required: " + solution.eraseOverLappingIntervals(intervals1));
        // Expected output: 1

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println("Minimum removals required: " + solution.eraseOverLappingIntervals(intervals2));
        // Expected output: 2

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println("Minimum removals required: " + solution.eraseOverLappingIntervals(intervals3));
        // Expected output: 0
    }
}
