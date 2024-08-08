package leetcodetop75;

public class IncreasingTripleSequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num<=first){
                first = num; // update first if num is smaller than or equal to first
            } else if (num<=second) {
                second = num; // update second if nums is larger than first but smaller than second
            }else{
                //If we find a number larger than both first and second
                return true;
            }
        }
        return false; // if no such triplet is found
    }
    public static void main(String[] args) {
        IncreasingTripleSequence solution = new IncreasingTripleSequence();
//        int[] nums1 = {1, 2, 3, 4, 5};
//        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {2, 1, 5, 0, 4, 6};

//        System.out.println(solution.increasingTriplet(nums1)); // Output: true
//        System.out.println(solution.increasingTriplet(nums2)); // Output: false
        System.out.println(solution.increasingTriplet(nums3)); // Output: true
    }
}
