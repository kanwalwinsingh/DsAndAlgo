package LeetCode;

public class StringToInteger {
    public static int myAtoi(String s) {
       int index = 0;
       int sign = 1;
       int total = 0;
       int n = s.length();
       //Step 1 remove indexes
        while (index<n && s.charAt(index) == ' '){
            index++;
        }
        //step 2 handles sign
        if(index<n && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            sign = s.charAt(index) =='-' ? -1: 1;
            index++;
        }

        //step 3: convert number and avoid overflow{
        while (index < n){
           int  digit = s.charAt(index)-'0';
           if(digit<0 || digit>9){
               break;
           }

           //check for overflow
            if(total>(Integer.MAX_VALUE -digit)/10){
                return (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total  = total*10 + digit;
            index++;
        }
        return total*sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(""));
    }
}
