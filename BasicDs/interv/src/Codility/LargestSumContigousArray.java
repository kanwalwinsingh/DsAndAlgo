package Codility;

public class LargestSumContigousArray {
    public static int soln(int[] arr){
        int maxSoFar = 0;
        int max_Ending = Integer.MIN_VALUE;
        for(Integer num : arr){
            maxSoFar = Math.max(maxSoFar+num, num);
            if(max_Ending<maxSoFar){
                max_Ending = maxSoFar;
            }
        }
        return max_Ending;
    }

    public static void main(String[] args) {
        System.out.println(soln(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
