package leetCodeTopInterview;

public class MaxRainWaterTrapped {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;
        while (left<right){
            if(height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else{
                    trappedWater += rightMax -height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        MaxRainWaterTrapped solution = new MaxRainWaterTrapped();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Amount of water trapped: " + solution.trap(height)); // Output: 6
    }
}
