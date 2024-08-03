package LeetCode;

public class NumberOfIslands {
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i =0; i< m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        //Check bound and if the cell is water or already visited
        if(i<0 || i>=m || j<0 || j>=m || grid[i][j] == '0') {return;}

        grid[i][j] = '0';

        //Explore adjacent cells
        dfs(grid,i+1, j); // down
        dfs(grid,i-1,j); //up
        dfs(grid,i,j+1); //right
        dfs(grid,i,j-1); //left
     }

    public static void main(String[] args) {
      char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
      NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
