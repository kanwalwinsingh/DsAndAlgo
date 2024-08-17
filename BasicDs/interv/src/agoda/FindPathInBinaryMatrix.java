package agoda;

import java.util.LinkedList;
import java.util.Queue;

public class FindPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 && grid[n-1][n-1] == 1){
            return -1; // return -1 because  there is no correct path
        }
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        grid[0][0] = 1;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int length = cell[2];
            if(row == n-1 && col == n-1){
                return length;
            }
            for (int [] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >=0 && newRow <n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 ){
                    queue.offer(new int[]{newRow,newCol,length+1});
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindPathInBinaryMatrix solver = new FindPathInBinaryMatrix();

        int[][] grid1 = {
                {0, 1},
                {1, 0}
        };

        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println("Shortest Path for grid1: " + solver.shortestPathBinaryMatrix(grid1)); // Output: 2
        System.out.println("Shortest Path for grid2: " + solver.shortestPathBinaryMatrix(grid2)); // Output: 4
    }
}
