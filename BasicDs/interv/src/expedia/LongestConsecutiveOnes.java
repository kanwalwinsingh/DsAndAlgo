package expedia;

public class LongestConsecutiveOnes {
    public static int maxConsecutive1(int n){
        int maxCount = 0;
        int consecutiveCount = 1;
        while (n>0){
            if((n & 1) == 1){
                consecutiveCount++;
                maxCount = Math.max(maxCount,consecutiveCount);
            }else{
                consecutiveCount = 0;
            }
            n = n>>1;
        }
        return  maxCount;
    }
    public static void main(String[] args) {
        int n = 14; // Example input
        System.out.println("The length of the longest consecutive 1s is: " + maxConsecutive1(n));
    }
}
