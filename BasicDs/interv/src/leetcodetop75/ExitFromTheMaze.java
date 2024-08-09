package leetcodetop75;

import java.util.LinkedList;
import java.util.Queue;

public class ExitFromTheMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        //Directions for moving in the maze: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            //Check if its' an exit (and not the entrance itself)
            if ((x != entrance[0] || y != entrance[1]) &&
                    (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                return steps;
            }

            //Explore all four directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                //Check if the new position is valid
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.' && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        //If no exit was found
        return -1;
    }

    public static void main(String[] args) {
        ExitFromTheMaze solution = new ExitFromTheMaze();

        char[][] maze1 = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance1 = {1, 2};
        System.out.println(solution.nearestExit(maze1, entrance1)); // Expected output: 1

        char[][] maze2 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance2 = {1, 0};
        System.out.println(solution.nearestExit(maze2, entrance2)); // Expected output: 2

        char[][] maze3 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance3 = {1, 1};
        System.out.println(solution.nearestExit(maze3, entrance3)); // Expected output: -1
    }

}
