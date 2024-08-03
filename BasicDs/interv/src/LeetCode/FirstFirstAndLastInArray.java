package LeetCode;

import java.util.Arrays;

public class FirstFirstAndLastInArray {
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int firstPos = -1;
        int lastPos = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                firstPos = mid;
                while (left<firstPos && nums[firstPos-1] == target) {
                    firstPos--;
                }
                lastPos = mid;
                while (lastPos <right && nums[lastPos+1]==target ) {
                    lastPos++;
                }
                return new int[]{firstPos, lastPos};
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int nums[] = {5,5,7,8,8,8};
        System.out.println(Arrays.toString(searchRange(nums,5)));
    }
}
