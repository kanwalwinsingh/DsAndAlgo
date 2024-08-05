package nikhil_lohia;

import java.util.Arrays;
import java.util.Deque;

public class DutchNationalFlagproblem {
    public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    int middle  = 0;
    while (middle<= right){
        switch (nums[middle]){
            case 0:
                int temp = nums[middle];
                nums[middle] = nums[left];
                nums[left] = temp;
                middle++;
                left++;
                break;
            case 2:
                int temp1 = nums[middle];
                nums[middle] = nums[right];
                nums[right] = temp1;
                right--;
                break;
            case 1:
                middle++;
                break;
        }
    }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        DutchNationalFlagproblem soln = new DutchNationalFlagproblem();
        soln.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
