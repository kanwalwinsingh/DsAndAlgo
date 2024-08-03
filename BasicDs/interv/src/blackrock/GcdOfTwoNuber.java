package blackrock;

public class GcdOfTwoNuber {
    public static void main(String[] args) {
        int a = 98, b = 56;
        System.out.print("GCD of " + a + " and " + b
                + " is " + gcdR(a, b));
    }

    static int gcd(int a, int b){
        int result = Math.min(a,b);
        while (result >= 0) {
            if(a%result == 0 && b%result == 0){
                break;
            }
            result--;
        }
       return result;
    }

    //recursive function to return GCD of a and b
    static int gcdR(int a, int b){
        //Everthing divides 0
        if(a == 0) return b;
        if (b == 0) return a;
        if(a == b) return a;
        if(a > b)
            return gcdR(a-b, b);
        return gcdR(a,b-a);
    }
}
