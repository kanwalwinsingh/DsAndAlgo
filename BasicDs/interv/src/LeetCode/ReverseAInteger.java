package LeetCode;

public class ReverseAInteger {
    public static int reverse(int x) {
        int sign = 1;
        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }if(x <0 ){
            sign = -1;
            x = x*sign;
        }
        String xa = String.valueOf(x);
        char[] a = xa.toCharArray();

        double sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
                sum += (a[i] - '0') * Math.pow((double) 10, (double) i);
        }
        if (sum > Integer.MAX_VALUE) {
            return 0;
        } else {
            int sum1 = (int) sum;
            return sum1 * sign;
        }
    }

    public static int reverseOptimal(int x){
        int reversed = 0;
        while (x!=0){

            int pop = x%10;
            x /= 10;

            //check for overflow/underflow before multiplying and adding
            if(reversed> Integer.MAX_VALUE/10 || reversed == Integer.MAX_VALUE/10 && pop>7){
                return 0;
            }
            if(reversed<Integer.MIN_VALUE/10 || reversed == Integer.MIN_VALUE/10 && pop<-8){
                return 0;
            }
            reversed = reversed*10 + pop;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseOptimal(120));
    }
}
