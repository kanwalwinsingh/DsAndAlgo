package main.java.algorithms.recursion;

public class PalindromeChaellenge {
    public static boolean isPalindrome(String text){
        if (text.length()<=1){
            return true;
        }
        else{
            if (text.charAt(0) == text.charAt(text.length()-1)){
                return isPalindrome(text.substring(1,text.length()-1));
            }
        }
        return false;
    }

    public static String reverseString(String myStr) {
        // Base case
        if (myStr.isEmpty()) {
            return myStr;
        }

        // Recursive case
        else {
            return reverseString(myStr.substring(1)) + myStr.charAt(0);
        }
    }
    public static void main( String args[] ) {
        String input1 = "hello";
        String input2 = "dadad";
        String answer1 = reverseString(input1);
        boolean answer2 = isPalindrome(input2);
        System.out.println("Is " + input1 + " a Palindrome? = " + answer1);
        System.out.println("Is " + input2 + " a Palindrome? = " + answer2);
    }
}
