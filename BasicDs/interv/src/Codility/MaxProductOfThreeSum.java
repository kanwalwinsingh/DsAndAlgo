package Codility;

public class MaxProductOfThreeSum {
    public static int solution(int[] A){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int num: A){
            if(num >max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if(num<min1){
                min2 = min1;
                min1 = num;
            } else if (num<min2) {
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3, max1*min2*min1);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }
}
