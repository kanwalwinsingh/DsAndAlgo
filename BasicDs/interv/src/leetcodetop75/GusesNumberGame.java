package leetcodetop75;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class GusesNumberGame {
    public int guessNumber(int n){
        int left = 1, right = n;
        while (left<=right){
            int mid = left+(right-left)/2; // To prevent overflow
            int result = guessNumber(mid);
            if(result == 0){
                return mid; // found the number
            }else if(result == -1){
                right = mid -1; // The number is lower
            }else{
                left = mid +1; // The number is higher
            }
        }
        return -1; // shuld never here since we are gurnteed to find the number
    }

}
