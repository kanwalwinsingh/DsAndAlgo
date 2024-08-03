package LeetCode;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int right = n-1;
        int left = 0;
        int mid = (right-left)/2 + left;
        while (left<=right){
            mid = (right-left)/2 + left;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                if(target<nums[mid] && nums[left]<=target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target>nums[mid] && nums[right] >= target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Example 1:

        int[] nums = {4,5,6,7,0,1,2}; int target = 0;
        System.out.println(search(nums,target));
//        Output: 4
//        Example 2:

        int[] nums1 = {4,5,6,7,0,1,2}; int target1 = 3;
//        Output: -1
//        Example 3:

        int[] nums2 = {1}; int target2 = 0;
//        Output: -1
    }
}
