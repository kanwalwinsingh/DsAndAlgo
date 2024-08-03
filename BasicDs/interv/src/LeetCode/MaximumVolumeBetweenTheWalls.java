package LeetCode;

public class MaximumVolumeBetweenTheWalls {
    public static int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            int width = right-left;
            int currentArea = width*Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,currentArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxWater = maxArea(heights);
        System.out.println("Maximum area of water container: " + maxWater);
    }
}
