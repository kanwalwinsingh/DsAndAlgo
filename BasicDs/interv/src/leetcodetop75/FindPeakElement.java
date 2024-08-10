package leetcodetop75;

public class FindPeakElement {
    public int findPeakElement(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while (left<right){
            int mid = left+(right-left)/2;

            //Compare middle element with its right neighbor
            if(nums[mid] <nums[mid+1]){
                //if mid is less than the next element, move to the right
                left = mid + 1;
            }else{
                //otherwise, move to the left
                right = mid;
            }
        }
        // when left to equal right, we have found a peek
        return left;
    }
    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        int peakIndex1 = solution.findPeakElement(nums1);
        System.out.println("Peak index in nums1: " + peakIndex1); // Expected output: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex2 = solution.findPeakElement(nums2);
        System.out.println("Peak index in nums2: " + peakIndex2); // Expected output: 5 or 1 (either is valid)

        int[] nums3 = {1};
        int peakIndex3 = solution.findPeakElement(nums3);
        System.out.println("Peak index in nums3: " + peakIndex3); // Expected output: 0
    }
}
