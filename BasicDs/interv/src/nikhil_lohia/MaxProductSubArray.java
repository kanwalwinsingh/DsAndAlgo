package nikhil_lohia;

public class MaxProductSubArray {
    public int maxProduct(int[] nums){
        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;
        long ans = nums[0];
        for(int i = 0; i<n; i++){
            leftProduct = (leftProduct == 0 || leftProduct<Integer.MIN_VALUE) ? 1 : leftProduct;
            rightProduct = (rightProduct == 0 || rightProduct<Integer.MIN_VALUE) ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];

            ans = Math.max(ans,Math.max(leftProduct,rightProduct));
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2, 4};
        MaxProductSubArray soln = new MaxProductSubArray();
        System.out.println(soln.maxProduct(nums));
    }
}
