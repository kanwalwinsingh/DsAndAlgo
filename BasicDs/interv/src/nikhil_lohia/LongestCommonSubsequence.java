package nikhil_lohia;

public class LongestCommonSubsequence {
    int longestCommonSubSequence(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //Iterate over each cell and updates values
        for(int i = 1; i<=text1.length(); i++){
            for(int j = 1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        // Example usage
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(solution.longestCommonSubSequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "abc";
        System.out.println(solution.longestCommonSubSequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "def";
        System.out.println(solution.longestCommonSubSequence(text1, text2)); // Output: 0
    }
}
