package main.java.algorithms.mergeintervalproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeNewIntervalInTheAlreadyIntervals {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval){
    int newStart = newInterval[0];
    int newEnd = newInterval[1];
    int i =0;
    int n = existingIntervals.length;
        List<int[]> ouputList = new ArrayList<>();
        while (i<n && existingIntervals[i][0] < newStart){
            ouputList.add(existingIntervals[i]);
            i+=1;
        }
        if(ouputList.size() == 0 || ouputList.get(ouputList.size()-1)[1] <newStart){
            ouputList.add(newInterval);
        }else {
            ouputList.get(ouputList.size()-1)[1] = Math.max(ouputList.get(ouputList.size()-1)[1], newEnd);
        }
        while (i<n){
            int[] ei = existingIntervals[i];
            int start = ei[0];
            int end = ei[1];
            int[] lastElementArray = ouputList.get(ouputList.size() - 1);
            if(lastElementArray[1]<start){
                ouputList.add(ei);
            }else {
                lastElementArray[1] = Math.max(lastElementArray[1],end);
            }
            i+=1;
        }
        return ouputList.toArray(new int[][]{});
    }

    // Driver code
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
