package main.java.leetcodeproblems.stringsproblem;

public class ReadIntegerFromString {
    public static int myAtoi(String s){
       int i =0, sign = 1, n= s.length();
       for(;i<n && s.charAt(i) == ' '; i++)
           ;
       if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
           sign = s.charAt(i++) == '-' ?-1:1;
        }
       long num = 0;
       for(;i<n && Character.isDigit(s.charAt(i)) && num<=Integer.MAX_VALUE;i++){
           num = num*10+s.charAt(i) - '0';
       }
       num = Math.max(sign*num,Integer.MIN_VALUE);
       num = Math.min(num,Integer.MAX_VALUE);
       return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
    }
}
