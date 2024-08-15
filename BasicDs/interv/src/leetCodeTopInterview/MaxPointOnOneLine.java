package leetCodeTopInterview;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnOneLine {
    public int maxPoints(int[][] points){
        if(points.length <= 2){
            return points.length;
        }
        int maxPointsOnLine = 0;
        for(int i =0; i< points.length; i++){
            Map<String,Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int currentMax = 0;
            for(int j = i+1; j<points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int deltaX = x2-x1;
                int deltaY = y2-y1;
                if(deltaX == 0 && deltaY == 0){
                    // duplicate point
                    duplicate++;
                }else{
                    //Calculate the slope
                    int gcd = gcd(deltaX,deltaY);
                    deltaX /=gcd;
                    deltaY /=gcd;
                    String slope = deltaY+"/"+deltaX;
                    slopeMap.put(slope,slopeMap.getOrDefault(slope,0)+1);
                    currentMax = Math.max(currentMax,slopeMap.get(slope));
                }
            }
            maxPointsOnLine = Math.max(currentMax+duplicate+1,maxPointsOnLine);
        }
        return maxPointsOnLine;
    }

    private int gcd(int a, int b) {
        if(b == 0 ){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        MaxPointOnOneLine sol = new MaxPointOnOneLine();
        int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,8}};
        System.out.println(sol.maxPoints(points));  // Output should be 6
    }
}
