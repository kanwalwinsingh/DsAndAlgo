package LeetCode;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        //Initialize the answer array with 1
        //This will hold the product of elements to the left of each index
        answer[0] = 1;
        for(int i =1; i<n; i++){
            answer[i] = nums[i-1] *answer[i-1];
        }

        //R will hold the product of elements to the right of each index
        int R =1;
        for(int i = n-1; i>=0; i--){
            answer[i] = answer[i]*R;
            R = R*nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
