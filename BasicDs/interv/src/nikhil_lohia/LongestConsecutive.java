package nikhil_lohia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for(int i =1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currentStreak++;
                }else {
                    longestStreak = Math.max(longestStreak,currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak,currentStreak);
    }

    public static int LongestConsecutiveOptimal(int[] nums){
        int longestLength = 0;
        Map<Integer,Boolean> numberTraveledmap = new HashMap<>();
        for(int num: nums){
            numberTraveledmap.put(num,Boolean.FALSE);
        }
        for(int num: nums){
            int currentLength = 1;
            int nextNum = num+1;
            while (numberTraveledmap.containsKey(nextNum) && numberTraveledmap.get(nextNum).equals(false)){
                currentLength++;
                numberTraveledmap.put(nextNum,true);
                nextNum++;
            }
            int prevNum = num-1;
            while (numberTraveledmap.containsKey(prevNum) && numberTraveledmap.get(prevNum).equals(false)){
                currentLength++;
                numberTraveledmap.put(prevNum,true);
                prevNum--;
            }
            longestLength = Math.max(longestLength,currentLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(LongestConsecutiveOptimal(nums));
    }
}
