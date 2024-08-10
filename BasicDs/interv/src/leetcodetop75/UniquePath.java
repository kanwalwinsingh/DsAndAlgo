package leetcodetop75;

public class UniquePath {
    public int uniquePath(int m, int n){
        //DP table
        int[][] dp = new int[m][n];

        //Initialize the first row and first column
        for(int i =0; i<m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j<n; j++){
            dp[0][j] = 1;
        }

        //Fill the dp table
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        //The result is stored on the bottom-right corner of the grid
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePath solution = new UniquePath();

        int m1 = 3, n1 = 7;
        System.out.println("Number of unique paths for a " + m1 + "x" + n1 + " grid: " + solution.uniquePath(m1, n1));
        // Expected output: 28

        int m2 = 3, n2 = 2;
        System.out.println("Number of unique paths for a " + m2 + "x" + n2 + " grid: " + solution.uniquePath(m2, n2));
        // Expected output: 3
    }

}
