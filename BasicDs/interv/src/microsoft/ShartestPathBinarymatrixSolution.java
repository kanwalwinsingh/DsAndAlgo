package microsoft;

import javax.crypto.ShortBufferException;
import java.util.LinkedList;
import java.util.Queue;

public class ShartestPathBinarymatrixSolution {
    public int shortestPathBinaryMatrix(int[][] grid){
        int n = grid.length;

        //Check if the start or end is blocked
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        //Direction vectors for 8 directions
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        //BFS queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); // (row, col, path length)
        grid[0][0] = 1; // mark as visited
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int length = cell[2];

            //Check if we have reached the bottom-right cell
            if(row == n-1 && col == n-1){
                return length;
            }

            // xplore 8 possible directions
            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];


                //Check if the new cell is within the bounds and is unvisited
                if(newRow >= 0 && newRow < n && newCol >=0 && newCol <n  && grid[newRow][newCol] == 0){
                    queue.offer(new int[]{newRow,newCol,length+1});
                    grid[newRow][newCol] = 1; // mark visited
                }
            }
        }

        //If we complete the BFS without finding the end, return -1;
        return -1;
    }
    public static void main(String[] args) {
        ShartestPathBinarymatrixSolution solution = new ShartestPathBinarymatrixSolution();
//        int[][] grid1 = {
//                {0, 1},
//                {1, 0}
//        };
        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
    //  System.out.println(solution.shortestPathBinaryMatrix(grid1)); // Output: 2
        System.out.println(solution.shortestPathBinaryMatrix(grid2)); // Output: 4
    }
}
