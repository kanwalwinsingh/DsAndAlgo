package nikhil_lohia;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    boolean isHappy(int n) {
        Set<Integer> sumCalc = new HashSet<>();
        while (true){
            int sum = 0;
            while (n!=0){
                sum+= Math.pow(n%10,2.0);
                n = n/10;
            }
            if(sum == 1){
                return true;
            }
            n = sum;
            if(sumCalc.contains(sum)){
                return false;
            }
            sumCalc.add(sum);
        }
    }
}
