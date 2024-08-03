package LeetCode;

public class DivideTwoNumbers {
    public static int divide(int dividend, int divisor) {
       //Handle the edge case
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean isNegative = false;

        //Determin the sign of the  result
        if((dividend<0 && divisor>0) ||(divisor<0 && dividend>0)){
            isNegative = true;
        }

        //Convert both dividend
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);

        int result =0;
        // Botwise shifting to find the quotient
        for(int i = 31; i>=0; i--){
            if((absDividend>>i) >= divisor){
                absDividend -=absDivisor<<i;
                result +=1<<i;
            }
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-10, 2));
    }
}
