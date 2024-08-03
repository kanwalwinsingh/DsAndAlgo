package LeetCode;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
       int slow = nums[0];
       int fast = nums[0];
       do{
           slow = nums[slow];
           fast = nums[nums[fast]];
       }while (slow !=fast);

       fast = nums[0];
       while (slow != fast){
           slow = nums[slow];
           fast = nums[fast];
       }
       return slow;
    }
    public static void main(String[] args) {
        FindDuplicateNumber solution = new FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums)); // Output: 2
    }
}
