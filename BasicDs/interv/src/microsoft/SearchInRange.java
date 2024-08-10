package microsoft;

import java.util.Arrays;

public class SearchInRange {
    public static int[] searchRange(int[] nums, int target) {
            int start = 0;
            int end = nums.length-1;
            if(nums == null || nums.length  == 1){
                return new int[]{-1,-1};
            }
            while (start<=end){
                int mid = start +(end-start)/2;
                if(nums[mid] == target){
                    int first = mid;
                    while (start<first && nums[first-1] == target){
                        first--;
                    }
                    int second = mid;
                    while (second<end && nums[second+1] == target){
                        second++;
                    }
                    return new int[]{first,second};

                }if(nums[mid] < target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {7};
        System.out.println(Arrays.toString(searchRange(nums,7)));
    }

}
