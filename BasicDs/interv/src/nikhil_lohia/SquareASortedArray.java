package nikhil_lohia;

import java.util.Arrays;

public class SquareASortedArray {
    public static int[] sortedSquares(int[] nums) {
    for (int i =0; i< nums.length; i++){
        nums[i] = nums[i]*nums[i];
    }
    int head = 0;
    int tail = nums.length-1;
    int[] newArray = new int[nums.length];
    for (int pos = nums.length-1; pos>=0; pos--){
        if (nums[head]>nums[tail]){
            newArray[pos] = nums[head];
            head++;
        }else  {
            newArray[pos] = nums[tail];
            tail--;
        }

    }
    return newArray;
    }

    public static void main(String[] args) {
        /**
         * Input: nums = [-4,-1,0,3,10]
         * Output: [0,1,9,16,100]
         * Explanation: After squaring, the array becomes [16,1,0,9,100].
         * After sorting, it becomes [0,1,9,16,100].
         */
//        int[] nums1 = {-4,-1,0,3,10};
//        System.out.println(Arrays.toString(sortedSquares(nums1)));
        int[] nums2 =  {-5,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }
}
