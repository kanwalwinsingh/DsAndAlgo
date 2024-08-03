package main.java.algorithms.bitwisemanipulation;

public class ComplementNumber {
    public static int findBitwiseComplement(int num){
        // if the value of num is 0, return 1
        if(num ==0){
            return 1;
        }
        //convert the value into its binary representation and count the number of bits required by this number
        int bitCount = (int) Math.floor((int) (Math.log(num)/Math.log(2)))+1;
        //compute the all bits of number
        int allBitsSet = (1<<bitCount)-1;
        //flip all bits of number by taking xor with allBits
        return num^allBitsSet;
    }
    public static void main(String[] args) {
        int[] decimalValues = {42, 233, 100, 999999, 54};

        for (int i = 0; i < decimalValues.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tInput: " + decimalValues[i]);
            System.out.print("\n\tBitwise complement of " + decimalValues[i] + " is: ");
            System.out.println(findBitwiseComplement(decimalValues[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
