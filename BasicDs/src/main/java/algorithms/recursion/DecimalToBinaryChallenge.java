package main.java.algorithms.recursion;

public class DecimalToBinaryChallenge {
    public static int decimalToBinary(int decimal){
        if (decimal == 0)
            return 0;
        else{
            return (decimal%2+10*decimalToBinary(decimal/2));
        }
    }
    public static void main( String args[] ) {
        int input = 27;
        int result = decimalToBinary(input);
        System.out.println("The binary form of " + input + " is: " + result);
    }

}
