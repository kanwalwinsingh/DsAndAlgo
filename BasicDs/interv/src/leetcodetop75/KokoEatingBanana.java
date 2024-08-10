package leetcodetop75;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75
 */
public class KokoEatingBanana {
    public int minEatingSpeed(int [] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left<=right){
            int mid = left+(right-left)/2;
            if(canEatAllBananas(piles,mid,h)){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    private boolean canEatAllBananas(int [] piles, int k, int h){
        int time =0;
        for(int pile : piles){
            time+= (pile + k-1)/k; // this is equvalent to ceil(pile/k)
            if(time>h){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        KokoEatingBanana solution = new KokoEatingBanana();

        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Minimum k for piles1: " + solution.minEatingSpeed(piles1, h1)); // Expected output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Minimum k for piles2: " + solution.minEatingSpeed(piles2, h2)); // Expected output: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Minimum k for piles3: " + solution.minEatingSpeed(piles3, h3)); // Expected output: 23
    }
}
