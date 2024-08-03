package Codility;

public class CommonPrimeDivisor {
    public  static int solution(int[] A, int[] B){
        int n = A.length;
        int count = 0;
        for(int i = 0; i<A.length; i++){
            if (hasSamePrimeDivisor(A[i],B[i])){
                count++;
            }
        }
        return count;
    }
    public static int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }

    public static boolean hasSamePrimeDivisor(int a, int b){
        int gcdvalue = gcd(a,b);
        int gcdA, gcdB;
        while (a!=1){
            gcdA = gcd(a,gcdvalue);
            if(gcdA == 1)
                break;
            a =a/gcdA;
        }
        if(a!=1){
            return false;
        }
        while (b!=1){
            gcdB = gcd(b,gcdvalue);
            if(gcdB == 1)
                break;
            b = b/gcdB;
        }
        return b==1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a1 = { 15, 10, 9 };
        int[] a2 = { 75, 30, 5 };
        int result2 = solution(a1, a2);
        System.out.println(result2);
    }
}
