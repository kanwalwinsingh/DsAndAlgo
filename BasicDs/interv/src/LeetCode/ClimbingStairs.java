package LeetCode;

public class ClimbingStairs {
    public int climbingStairs(int n){
        if(n<=1){
            return 1;
        }
        int first = 1; // ways to reach step 0
        int second = 1; // ways to reach step 1
        for(int i =2; i<=n; i++){
            int current = first+second;
            first = second;
            second = current;
        }
        return second;
    }

    public int climbingStairsDp(int n){
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1 ; //1 way to stay at ground
        dp[1] = 1; //1 way to reach to the 1
        for(int i =2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbingStairsDp(2));  // Output: 2
        System.out.println(cs.climbingStairsDp(3));  // Output: 3
        System.out.println(cs.climbingStairsDp(4));  // Output: 5
    }
}
