package leetcodetop75;

import java.util.Arrays;

public class BurstBallonWithMinimumShots {
    public int findMinArrowShots(int[][] points){
        if(points.length == 0){
            return 0;
        }
        // Sort intervals by their end points
        Arrays.sort(points, (a,b)->a[1]-b[1]);

        int arrow = 1;
        int end = points[0][1];

        //Travers through all balloons
        for(int i = 1; i<points.length; i++){
            //If the current baloon starts after the last arrow's end point, we need a new arrow
            if(points[i][0] > end){
                arrow++;
                end = points[i][1]; // Update the end to the current ballon's end
            }
        }
        return arrow;
    }
    // Driver code to test the solution
    public static void main(String[] args) {
        BurstBallonWithMinimumShots solution = new BurstBallonWithMinimumShots();

        int[][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Minimum number of arrows required: " + solution.findMinArrowShots(points1));
        // Expected output: 2

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Minimum number of arrows required: " + solution.findMinArrowShots(points2));
        // Expected output: 4

        int[][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println("Minimum number of arrows required: " + solution.findMinArrowShots(points3));
        // Expected output: 2
    }
}
