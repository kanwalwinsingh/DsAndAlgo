package nikhil_lohia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumInArrayEqualsToZero {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null && nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum<target) {
                    left++;
                }else {
                    right --;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ThreeSumInArrayEqualsToZero solution = new ThreeSumInArrayEqualsToZero();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);  // Expected output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
