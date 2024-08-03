package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoko {
    public static boolean isValidSudoku(char[][] board) {
        // Sets to keep track of the seen numbers in the row, cols, and sub-boxes
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    //check row
                    if (! seen.add("row" + i + num)) {
                        return false;
                    }
                    //check columns
                    if (!seen.add("col" + j + num)) {
                        return false;
                    }
                    //check box
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (!seen.add("box" + boxIndex + num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Test cases
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Board 1 is valid: " + isValidSudoku(board1)); // Output: true
        System.out.println("Board 2 is valid: " + isValidSudoku(board2)); // Output: false
    }
}
