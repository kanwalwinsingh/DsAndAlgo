package leetcodetop75;

import java.util.HashMap;

public class GreatestCommonDivisorOfString {
    public static String gcdOfStrings(String str1, String str2){
        //Check if str1+str2 equals str2+str1
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        //Find the gcd of length
        int gcdLength = gcd(str1.length(), str2.length());

        //The GCD string is the prefix of str1 (or str2) with length gcdlength
        return str1.substring(0,gcdLength);
    }

    private static int gcd(int a, int b){
        while (b!= 0){
            int temp = b;
            b = b%a;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String str1 = "leet";
        String str2 = "code";

        System.out.println("The GCD of strings \"" + str1 + "\" and \"" + str2 + "\" is: \"" + gcdOfStrings(str1, str2) + "\"");
    }

}
