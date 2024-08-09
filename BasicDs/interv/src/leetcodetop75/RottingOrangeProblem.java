package leetcodetop75;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangeProblem {
    public int orangesRotting(int[][] grid){
        if(grid == null || grid.length == 0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        //Initialize the queue with all rotten oranges and count fresh oranges;
        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if(freshOranges == 0) return 0;

        int minuteElapsed = -1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        //Perform BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()){
            int size = queue.size();
            minuteElapsed++;
            for(int i =0; i<size; i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for(int[] direction : directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // If the adjacent cell is within bounds and has a fresh orange.
                    if(newRow >= 0 && newRow<rows && newCol >= 0 && newCol <cols && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] {newRow,newCol});
                        freshOranges--;
                    }
                }
            }
        }
        return freshOranges == 0 ? minuteElapsed :-1;
    }

    public static void main(String[] args) {
        RottingOrangeProblem solution = new RottingOrangeProblem();

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int[][] grid3 = {
                {0, 2}
        };

        System.out.println("Grid 1: " + solution.orangesRotting(grid1)); // Output: 4
        System.out.println("Grid 2: " + solution.orangesRotting(grid2)); // Output: -1
        System.out.println("Grid 3: " + solution.orangesRotting(grid3)); // Output: 0
    }
}
