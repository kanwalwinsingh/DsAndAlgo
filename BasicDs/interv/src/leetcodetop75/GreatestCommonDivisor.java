package leetcodetop75;

public class GreatestCommonDivisor {
    
    // Method to find GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;
        
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd(num1, num2));
    }
}