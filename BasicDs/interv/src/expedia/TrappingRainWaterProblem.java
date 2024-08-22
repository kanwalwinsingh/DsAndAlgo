package expedia;

public class TrappingRainWaterProblem {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
        int totalWaterCount = 0;
        while (left<right){
            if(height[left] < height[right]){
                if(height[left] >= maxHeightLeft){
                    maxHeightLeft = height[left];
                }else{
                    totalWaterCount += maxHeightLeft - height[left];
                }
                left++;
            }else{
                if(height[right] >= maxHeightRight){
                    maxHeightRight = height[right];
                }else{
                    totalWaterCount += maxHeightRight - height[right];
                }
                right--;
            }
        }
        return totalWaterCount;
    }
}
