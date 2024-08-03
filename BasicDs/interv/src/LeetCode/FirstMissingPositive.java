package LeetCode;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for(int i =0; i<n; i++){
            while (nums[i]>0 && nums[i]<=n && (nums[i] != nums[nums[i] -1])){
                temp = nums[nums[i] -1];
                nums[nums[i] -1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i =0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,0};
        System.out.println(firstMissingPositive(a));
        int[] b = {3,4,-1,1};
        System.out.println(firstMissingPositive(b));
        int[] c = {7,8,9,11,12};
        System.out.println(firstMissingPositive(c));
    }
}
