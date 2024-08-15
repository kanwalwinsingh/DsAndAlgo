package leetCodeTopInterview;

public class LongestPathInMatrix {
    private int[][] dirs =  {{0,1},{1,0},{0,-1},{-1,0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxLength = 0;

        //Perform DFS from each cell
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                maxLength = Math.max(maxLength,dfs(matrix,i,j,memo));
            }
        }
        return maxLength;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo){
        if(memo[i][j] != 0) return memo[i][j]; // Return memozied result if available
        int max = 1; // The length of the path starting from this cell
        for(int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>= 0 && x<m && y>=0 && y<n && matrix[x][y] > matrix[i][j]){
                max = Math.max(max, 1+dfs(matrix,x,y,memo));
            }
        }
        memo[i][j] = max; // Store the result in memoziation table
        return max;
    }
    public static void main(String[] args) {
        LongestPathInMatrix solution = new LongestPathInMatrix();

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int result = solution.longestIncreasingPath(matrix);

        System.out.println("Length of the Longest Increasing Path:");
        System.out.println(result); // Output: 4
    }
}
