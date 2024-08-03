package StriverSDESheet;

public class SetMatrixZero {
    public int[][] solution(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        boolean firstRowZero = false;
        boolean firstcolZero = false;

        //Determine if the first row or first column is initally zero
        for(int i =0; i< m; i++){
            if(nums[i][0] == 0){
                firstcolZero = true;
            }
        }
        for(int j =0; j<m; j++){
            if(nums[0][j] == 0){
                firstRowZero = true;
            }
        }

        for(int i =1; i <m; i++ ){
            for(int j =0; j<n; j++){
                if(nums[i][j] == 0){
                    nums[i][0] = 0;
                    nums[0][j] = 0;
                }
            }
        }
        // set matrix cells to zero
        for(int i =1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(nums[i][0] == 0 || nums[0][j] == 0){
                    nums[i][j] = 0;
                }
            }
        }

        //Handle the first row and first column seprately
        if(firstRowZero){
            for(int j =0; j<n; j++){
                nums[0][j] = 0;
            }
        }
        if(firstcolZero){
            for(int i =0; i<m; i++){
                nums[i][0] = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Initialize the matrix
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        // Print the original matrix
        System.out.println("Original matrix:");
        printMatrix(matrix);

        // Call the setZeroes method to modify the matrix
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        setMatrixZero.solution(matrix);

        // Print the modified matrix
        System.out.println("Modified matrix:");
        printMatrix(matrix);
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

