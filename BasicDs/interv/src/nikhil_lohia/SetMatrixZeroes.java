package nikhil_lohia;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //Replace inner matrix
        for (int i =1; i<n; i++){
            for (int j =1; j<m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //Last remaining checks
        if(firstRow){
           for(int j =0; j<m; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstCol){
            for (int i =0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix1);
        // Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        for (int[] row : matrix1) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix2);
        // Output: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
        for (int[] row : matrix2) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
