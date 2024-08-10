package leetcodetop75;
/*
https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MinimumFlipRequireForBinaryOperation {
    public int minFlips(int a, int b, int c){
        int flips = 0;
        for(int i =0; i<32; i++){
            //Get the i-th bit of a,b and c
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if(bitC == 0){
                //if c[i] is 0, both a[i] and b[i] should be 0
                flips += bitA+bitB; // if bitA or bitB is 1, we need to flip them
            }else{
                //If c[i] is 1, at least one of a[i] or b[i] should be 1
                if(bitA == 0 && bitB == 0){
                    flips+=1; // need to flip either a[i] or b[i] to 1
                }
            }
        }
        return flips;
    }
    // Driver code to test the solution
    public static void main(String[] args) {
        MinimumFlipRequireForBinaryOperation solution = new MinimumFlipRequireForBinaryOperation();

        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println("Minimum flips required: " + solution.minFlips(a1, b1, c1));
        // Expected output: 3 (because 2 = 0010, 6 = 0110, 5 = 0101, need 3 flips)

        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println("Minimum flips required: " + solution.minFlips(a2, b2, c2));
        // Expected output: 1 (because 4 = 0100, 2 = 0010, 7 = 0111, need 1 flip)
    }
}
