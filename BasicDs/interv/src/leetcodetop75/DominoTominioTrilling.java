package leetcodetop75;

public class DominoTominioTrilling {
    public int numTiling(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int MOD = 1_000_000_007;
        //dp and dp2 arrays
        int[] dp = new int[n+1];
        int[] dp2 = new int[n+1];

        //base case
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp2[1] = 1;
        dp[2]  = 2;

        //Fill dp and dp2 arrays
        for(int i = 3; i<=n; i++){
            dp2[i] = (dp[i-2] + dp2[i-1])%MOD;
            dp[i] = (dp[i-1]+dp[i-2]+2*dp2[i-1])%MOD;
        }
        return dp[n];

    }
}
