package agoda;

import java.util.List;

public class SumWithOverflowHandling {
    //Constant for 32-bit integer limit
    public static final int INT_MAX = 2147483647;
    public static final int INT_MIN = -2147483648;

    public static int sumWithOverflowingInteger(List<Integer> numbers){
        int sum = 0;
        for(int number : numbers){
            // Check if adding the number will cause overflow
            if(sum>0 && number > 0 && sum> INT_MAX-number){
                sum = sum-(INT_MAX+1) + number;
            } else if (sum<0 && number <0 && sum < INT_MIN - number) {
                // overflow in negative direction
                sum = sum-(INT_MIN-1)+number;
            }else {
                sum +=number;
            }
        }
        return sum;
    }
    public static void main(String[] args) {

        List<Integer> numbers = List.of(2147483647, 1, -2147483648, -1);

        int result = sumWithOverflowingInteger(numbers);
        System.out.println("Sum with 32-bit overflow handling: " + result);
    }
}
