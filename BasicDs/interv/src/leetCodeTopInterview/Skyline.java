package leetCodeTopInterview;

import java.util.*;

public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        //Step 1: Break each building into two events
        for(int[] building: buildings){
            heights.add(new int[]{building[0], -building[2]}); // left edge
            heights.add(new int[]{building[1], building[2]}); // right edge
        }

        //Step 2:  sort events
        Collections.sort(heights, (a,b)->{
            if(a[0] != b[0]){
                return a[0] - b[0]; // Sort by x coordinates
            }
            return a[1]-b[1]; // Sort by height
        });

        //Step 3: use a max-heap to maintain the current activity
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(0); //Initalize the ground level

        int prevHeight = 0;
        for(int[] h: heights){
            int x = h[0];
            int height = h[1];

            if(height<0){
                pq.offer(-height);
            }else{
                pq.remove(height);
            }

            int currentMaxHeight = pq.peek(); // current max height in the priority queue

            if(currentMaxHeight != prevHeight){
                result.add(Arrays.asList(x,currentMaxHeight));
                prevHeight = currentMaxHeight;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Skyline sol = new Skyline();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        var skyline = sol.getSkyline(buildings);
        for (var point : skyline) {
            System.out.println(point);
        }
    }
}
