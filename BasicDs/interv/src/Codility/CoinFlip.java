package Codility;

/**
 * Initial State: All coins are heads (H).
 * Flipping Rule: Each person i flips every i-th coin.
 * Person 1 flips all coins (1, 2, 3, 4, ...).
 * Person 2 flips every 2nd coin (2, 4, 6, 8, ...).
 * Person 3 flips every 3rd coin (3, 6, 9, ...).
 * And so on.
 */
public class CoinFlip {
    /**
     * A coin ends up showing tails if it has been flipped an odd number of times. A coin is flipped every time one of its divisors acts on it. For example, coin number 6 is flipped by person 1, person 2, person 3, and person 6.
     *
     * Coins that have an odd number of divisors are perfect squares. This is because divisors come in pairs (e.g., for 6: (1,6), (2,3)), except when the number is a perfect square (e.g., for 9: (1,9), (3,3)).
     *
     * Solution:
     * The number of coins showing tails is the number of perfect squares up to n.
     */

    public static int solution(int n){
        int count = 0;
        for (int i = 1; i*i <= n; i++){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
