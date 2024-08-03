package nikhil_lohia;

public class CountSeversThatCommunicate {
    public int countServer(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        //Step 1: Count the number of servers in each row and in each column
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 2. Determine the number of servers that communicate
        int communicationServer = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1 && (rowCount[i] >1 || colCount[j] >1)){
                    communicationServer++;
                }
            }
        }
        return communicationServer;
    }
    public static void main(String[] args) {
        CountSeversThatCommunicate solution = new CountSeversThatCommunicate();

        int[][] grid1 = {
                {1, 0},
                {0, 1}
        };
        System.out.println(solution.countServer(grid1));  // Output: 0

        int[][] grid2 = {
                {1, 0},
                {1, 1}
        };
        System.out.println(solution.countServer(grid2));  // Output: 3

        int[][] grid3 = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };
        System.out.println(solution.countServer(grid3));  // Output: 6
    }
}
