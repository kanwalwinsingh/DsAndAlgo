package expedia;



import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> results = new ArrayList<>();
        int[] currentInterval = intervals[0];
        results.add(currentInterval);
        for(int[] interval : intervals){
            if(interval[0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1],interval[1]);
            }else{
                currentInterval = interval;
                results.add(interval);
            }
        }
        return results.toArray(new int[results.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals
 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        MergeIntervals solution = new MergeIntervals();
        int[][] mergedIntervals = solution.merge(intervals);
        System.out.println(Arrays.deepToString(mergedIntervals));
    }
}
