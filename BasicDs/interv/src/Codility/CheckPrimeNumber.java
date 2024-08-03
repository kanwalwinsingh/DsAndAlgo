package Codility;

public class CheckPrimeNumber {
    public static boolean isPrime(int n){
        //Initial Check
        if(n<=1){
            return false;
        }
        if(n ==2 || n == 3){
            return true;
        }
        for (int i = 2 ; i<n/2; i++ ){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeAnotherWay(int number){
        if(number<=1){
            return false;
        }
        for(int i = 2; i*i<= number; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrimeAnotherWay(29));
    }
}
