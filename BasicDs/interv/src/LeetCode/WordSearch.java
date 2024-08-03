package LeetCode;

public class WordSearch {
    public boolean exist(char[][] board, String word){
        int rows = board.length;
        int cols = board[0].length;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] boards,String word, int i, int j, int index){
        if(index == word.length()){
            return true; // all charactes are checked;
        }
        if(i<0 || j<0 || i>=boards.length || j>=boards[0].length || boards[i][j] !=word.charAt(index) ){
            return false;
        }
        // tempoarily mark the cell as visited
        char temp = boards[i][j];
        boards[i][j] = '#';

        boolean found = dfs(boards,word,i+1,j,index+1) ||
                        dfs(boards,word,i-1,j,index+1) ||
                        dfs(boards,word,i,j+1,index+1) ||
                        dfs(boards,word,i,j-1,index+1);

        boards[i][j] = temp;
        return found;

    }
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED"; // true
        String word2 = "SEE";    // true
        String word3 = "ABCB";   // false

        System.out.println(wordSearch.exist(board, word1)); // Output: true
        System.out.println(wordSearch.exist(board, word2)); // Output: true
        System.out.println(wordSearch.exist(board, word3)); // Output: false
    }
}
