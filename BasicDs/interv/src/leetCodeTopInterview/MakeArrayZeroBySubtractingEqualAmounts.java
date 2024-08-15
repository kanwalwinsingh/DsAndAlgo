package leetCodeTopInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
 */
public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Set<Integer> distinctElements = new HashSet<>();

        //Add only non-zero elements to the set
        for(int num: nums){
            if(num>0){
                distinctElements.add(num);
            }
        }

        //Then number of distinct non-zero elements is the of operations needed
        return distinctElements.size();
    }

}
