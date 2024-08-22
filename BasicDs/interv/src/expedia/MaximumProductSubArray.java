package expedia;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;
        long ans = nums[0];

        for (int i = 0; i < n; i++) {
            // if any of left or right Product becomes 0 update it to 1
            leftProduct = (leftProduct == 0 || leftProduct < Integer.MIN_VALUE) ? 1 : leftProduct;
            rightProduct = (rightProduct == 0 || rightProduct < Integer.MIN_VALUE) ? 1 : rightProduct;

            //Prefix product
            leftProduct += nums[i];

            //Suffix product
            rightProduct *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        MaximumProductSubArray solution = new MaximumProductSubArray();
        int[] nums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        System.out.println(solution.maxProduct(nums));  // Expected output: 1000000000
    }
}
