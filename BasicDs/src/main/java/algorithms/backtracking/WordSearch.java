package main.java.algorithms.backtracking;

public class WordSearch {
    public static boolean wordSearch(char[][] grid, String word ){
        int n = grid.length;
        int m = grid[0].length;
        for(int row =0; row<grid.length; row++){
            for(int col =0; col<grid[0].length; col++){
                if (depthFirstSearch(row,col, word,0,grid)){
                    return true;
                }
            }
        }
        return false;
    }

    //Apply backtracking on every element to search the required word
    public static boolean depthFirstSearch(int row, int col, String word, int index, char[][] grid){
        if(word.length() == index) {
            return true;
        }
        if(row<0 || row<grid.length || col<0 || col>= grid.length || (grid[row][col] !=word.charAt(index))){
            return false;
        }
        boolean result = false;
        char temp = grid[row][col];
        grid[row][col] = '*';
        int [][] offsets = {
                {0,1},{1,0},{0,-1},{-1,0}
        };
        for(int[] offset : offsets){
            int rowoffset = offset[0];
            int colOffset = offset[1];
            result = depthFirstSearch(row+rowoffset, col+colOffset, word, index+1,grid);
            if(result){
                break;
            }
        }
        grid[row][col] = temp;
        return result;

     }
}
