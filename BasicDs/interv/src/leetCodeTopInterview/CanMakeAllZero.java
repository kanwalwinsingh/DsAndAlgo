package leetCodeTopInterview;

public class CanMakeAllZero {
    public static boolean canMakeAllZero(int[] nums, int k){
        int n = nums.length;
        long totalSum = 0;

        //Calculate the total su of the array
        for(int num : nums){
            totalSum += num;
        }

        //If the total sum is not divisible by k, return false
        if(totalSum %k != 0){
            return false;
        }

        //Greedily reduce the array
        for(int i = 0; i<= n-k; i++){
            if(nums[i] > 0){
                int reduceAmount = nums[i]; // The amount to reduce in the subArray

                //Reduce the subArray [i, i+k-1] by reduceAmmount
                for(int j =0; j<k; j++){
                    nums[i+j] -= reduceAmount;
                }
            }
        }


        // Check if all elements are reduced to 0
        for(int num : nums) {
            if(num != 0){
                return false;
            }
        }
        return true;
    }




    //Optimal Solution
    public static boolean canMakeAllZeroOptimal(int[] nums, int k){
        int sum =0;
        for(int i =0; i<nums.length; i++){
            if(sum>nums[i]){
                return false;
            }
            nums[i]-=sum;
            sum += nums[i];
            if(i>=k-1){
                sum -=nums[i-k +1];
            }
        }
        return sum == 0;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 1, 1, 0};
        int k1 = 3;
//
//        int[] nums2 = {3, 3, 3, 3};
//        int k2 = 2;

        int[] nums3 = {1,3,1,1};
        int k3 = 2;
        System.out.println(canMakeAllZeroOptimal(nums1, k1)); // Output: true
//        System.out.println(canMakeAllZeroOptimal(nums2, k2)); // Output: true
        System.out.println(canMakeAllZeroOptimal(nums3, k3)); // Output: false
    }
}
