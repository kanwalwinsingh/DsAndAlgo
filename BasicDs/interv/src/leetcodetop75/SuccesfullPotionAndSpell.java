package leetcodetop75;

import java.util.Arrays;

public class SuccesfullPotionAndSpell {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        //Sort the potions array
        Arrays.sort(potions);

        for(int i =0; i<n; i++){
            int spell = spells[i];

            //Calculate the threshold for a successful pair
            long threshold = (success + spell -1)/spell; // equivalent to cieling (success/spell)

            //Binary search for the first potion that meets or exceeds the threshold
            int left = 0, right = m;
            while (left<right){
                int mid = left+(right-left)/2;
                if(potions[mid] >= threshold){
                    right = mid;
                }else{
                    left = mid-1;
                }
            }
            //The number of successfull pairs is the number of potions from left to the m
            pairs[i] = m-left;
        }
        return pairs;
    }

    public int[] successFullPairsOptimal(int[] spells, int[] potions, long success){       int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; ++i)
            ans[i] = potions.length - firstIndexSuccess(spells[i], potions, success);

        return ans;
    }

    // Returns the first index i s.t. spell * potions[i] >= success.
    private int firstIndexSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            final int m = l +(r - l) / 2;
            if ((long) spell * potions[m] >= success)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        SuccesfullPotionAndSpell solution = new SuccesfullPotionAndSpell();

        int[] spells1 = {10, 3, 7};
        int[] potions1 = {5, 8, 3, 10};
        int success1 = 30;
        System.out.println("Successful Pairs: " + Arrays.toString(solution.successFullPairsOptimal(spells1, potions1, success1)));
        // Expected output: [3, 0, 2]

        int[] spells2 = {4, 9, 5};
        int[] potions2 = {1, 3, 6, 10};
        int success2 = 24;
        System.out.println("Successful Pairs: " + Arrays.toString(solution.successFullPairsOptimal(spells2, potions2, success2)));
        // Expected output: [2, 3, 2]
    }
}
