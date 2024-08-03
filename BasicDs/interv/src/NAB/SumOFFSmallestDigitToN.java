package NAB;

//https://www.geeksforgeeks.org/find-the-smallest-number-whose-sum-of-digits-is-n/
public class SumOFFSmallestDigitToN {

    // function to get sum of digits
    static int getSum(int n){
        int sum =0;
        while (n != 0){
            sum = sum +n%10;
            n = n/10;
        }
        return sum;
    }

    //naive aproach
    static void smallestNumber(int N){
        int i =1;
        while (true){
            //Checking if number has sum of digits = N
            if(getSum(i) == N){
                System.out.println(i);
                break;
            }
            i++;
        }
    }


    static void smallestNumberEff(int N){
        int k = (int) ((N%9+1) * Math.pow(10,(N/9))-1);
        System.out.println(k);
    }

    public static void findSmallestSolution(int N){
        if(N == 0) System.out.println(0);
        StringBuilder result = new StringBuilder();
        while (N>0){
            int digit = Math.min(N,9);
            result.insert(0,digit);
            N -=digit;
        }
        System.out.println(result.toString());
    }



    public static void main(String[] args) {
        findSmallestSolution(19);
    }
}
