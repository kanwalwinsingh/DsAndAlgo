package agoda;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsMatrix {
    static class Position {
        int row, col, steps;
        Position(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int minStepsToReachEnd(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        //Edge case for 1*1 matrix
        boolean[][] visited = new boolean[m][n];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0,0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Position pos = queue.poll();
            int i = pos.row, j= pos.col, steps = pos.steps;
            //Possible moves
            int right = j + matrix[i][j];
            int down = i + matrix[i][j];

            // Check if we can move right
            if(right < n && !visited[i][right]){
                if( i == m-1 && right == n-1){
                    return steps + 1; // Found the end
                }
                queue.add(new Position(i,right,steps+1));
                visited[i][right] = true;
            }

            // Check if we can move down
            if(down < m && !visited[down][j]){
                if(down == m-1 && j == n-1){
                    return steps + 1; // Found the end
                }
                queue.add(new Position(down,j,steps+1));
                visited[down][j] = true;
            }
        }
         return -1; // No path found
    }

    public static void main(String[] args) {
        MinimumStepsMatrix solver = new MinimumStepsMatrix();

        int[][] matrix1 = {
                {2, 3, 1, 1},
                {1, 2, 1, 2},
                {1, 1, 1, 1},
                {1, 2, 2, 1}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Minimum steps for matrix1: " + solver.minStepsToReachEnd(matrix1)); // Output: 2
        System.out.println("Minimum steps for matrix2: " + solver.minStepsToReachEnd(matrix2)); // Output: -
    }
}
