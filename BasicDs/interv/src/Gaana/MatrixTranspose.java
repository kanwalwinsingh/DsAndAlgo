package Gaana;

public class MatrixTranspose {
    public static int[][] transposeMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return new int[0][0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposeMatrix = new int[cols][rows];

        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int[] row: matrix){
            for(int elem : row){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] transposed = transposeMatrix(matrix);

        System.out.println("Transposed Matrix:");
        printMatrix(transposed);
    }
}
