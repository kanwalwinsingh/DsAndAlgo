package nikhil_lohia;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int votes = 1, majorityElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                votes++;
            } else {
                votes--;
            }
            if (votes == 0) {
                majorityElement = nums[i];
                votes++;
            }
        }
        return majorityElement;
    }
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        int[] nums1 = {3, 2, 3};
        System.out.println(solution.majorityElement(nums1));  // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums2));  // Output: 2
    }
}
