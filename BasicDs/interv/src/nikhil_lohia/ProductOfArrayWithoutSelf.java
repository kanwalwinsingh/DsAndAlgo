package nikhil_lohia;

import java.util.Arrays;

public class ProductOfArrayWithoutSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftArray = new int[n];
        leftArray[0] = 1;
        for(int i =1; i<n; i++){
            leftArray[i] = nums[i-1]*leftArray[i-1];
        }
        int r = 1;
        for (int j = n-2; j>=0; j--)
        {
          r = r*nums[j+1];
          leftArray[j] = leftArray[j]*r;
        }
        return leftArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
