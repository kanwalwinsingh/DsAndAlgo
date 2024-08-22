package expedia;

import java.util.ArrayList;
import java.util.List;

public class KthFactor {
    public int KthFactor(int n, int k) {
        int count = 0;
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        //Sort the factor
        factors.sort(Integer::compareTo);

        //Check if we have enough factors
        if (k <= factors.size()) {
            return factors.get(k - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 12, k = 3;
        KthFactor solution = new KthFactor();
        int result = solution.KthFactor(n, k);
        System.out.println(result); // Output: 3
    }
}
