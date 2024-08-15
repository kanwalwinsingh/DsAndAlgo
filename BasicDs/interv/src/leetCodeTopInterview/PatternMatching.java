package leetCodeTopInterview;

public class PatternMatching {
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        //Base case : empty string matches empty pattern
        dp[0][0] = true;

        //Handle patterns like a*, a*b*, a*b*c* etc.
        for (int j = 1; j<=n; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        //Fill the DP table
        for(int i = 1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    // Two cases:
                    // 1. dp[i][j-2]: Ignore the "*" and precceding element
                    // 2. dp[i-1][j]: "*" matches one or more preceding element, if applicable
                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        PatternMatching regexMatching = new PatternMatching();
        String s = "aab";
        String p = "c*a*b";
        boolean result = regexMatching.isMatch(s, p);
        System.out.println("Does the string match the pattern? " + result);
    }
}
