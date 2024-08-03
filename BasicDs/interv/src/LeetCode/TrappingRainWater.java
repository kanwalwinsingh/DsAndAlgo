package LeetCode;

public class TrappingRainWater {
    public int trap(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int left =0, right = height.length-1;
        int left_max =0, right_max = 0;
        int waterTrapped =0;
        while (left<right){
            if(height[left] < height[right]){
                if (height[left]>=left_max) {
                    left_max = height[left];
                }else{
                    waterTrapped += left_max-height[left];
                }
                left++;
            }else {
                if(height[right]>=right_max){
                    right_max = height[right];
                }else{
                    waterTrapped +=right_max-height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total water trapped: " + solution.trap(height)); // Output: 6
    }
}
