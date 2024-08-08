package nikhil_lohia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    int[][] merge(int[][] intervals){
        if(intervals.length <=1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for(int[] interval : intervals){
            if(interval[0] <=currentInterval[1]){
                currentInterval[1] = Math.max(interval[1],currentInterval[1]);
            }else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        MergeInterval solution = new MergeInterval();

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println(Arrays.deepToString(result1)); // Expected output: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println(Arrays.deepToString(result2)); // Expected output: [[1, 5]]
    }
}
