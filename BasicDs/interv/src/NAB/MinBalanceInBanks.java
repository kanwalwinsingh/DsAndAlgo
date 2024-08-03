package NAB;

/**
 * https://www.chegg.com/homework-help/questions-and-answers/write-solution-java-8-given-list-n-transfers-numbered-0-n-1-two-banks-bank-bank-b-k-th-tra-q169942005
 */
public class MinBalanceInBanks {
    public static int[] findInitialBalances(String R, int[] V) {
        int n = R.length();
        int balanceA = 0, balanceB = 0;
        int minBalanceA = 0, minBalanceB = 0;

        for (int i = 0; i < n; ++i) {
            if (R.charAt(i) == 'A') {
                balanceA += V[i];
                balanceB -= V[i];
            } else {
                balanceB += V[i];
                balanceA -= V[i];
            }

            minBalanceA = Math.min(minBalanceA, balanceA);
            minBalanceB = Math.min(minBalanceB, balanceB);
        }

        return new int[]{-minBalanceA, -minBalanceB};
    }

    public static void main(String[] args) {
        String R = "BAABA";
        int[] V = {2, 4, 1, 1, 2};
        int[] result = findInitialBalances(R, V);
        System.out.println("Initial balances for bank A and B are: " + result[0] + ", " + result[1]);
    }
}