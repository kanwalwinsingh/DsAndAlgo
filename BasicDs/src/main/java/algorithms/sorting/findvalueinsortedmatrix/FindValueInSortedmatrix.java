package main.java.algorithms.sorting.findvalueinsortedmatrix;

public class FindValueInSortedmatrix {
    //BruteForce
    public static Object findKey(int[][] matrix, int numberOfRows, int numberofColumns, int target){
        for(int i =0; i< numberOfRows; i++){
            for(int j =0; j<numberofColumns; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    //Moving directions
    public static Object findKeyMovingDirection(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int i = numberOfRows-1;
        int j =0;
        while(i>0 && j<numberOfColumns){
            if(matrix[i][j] == target){
                return true;
            }
            if(target>matrix[i][j]){
                j++;
            }else {
                i--;
            }
        }
        return false;
    }

    //O(logn+logm)
    public static Object findKeyUsingBinarySearch(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int min = 0;
        int max = numberOfRows+numberOfColumns-1;
        while (min<=max){
            int middle = (min+max)/2;
            int row = middle/numberOfColumns;
            int col = middle%numberOfColumns;
            if(target<matrix[row][col]){
                max = middle-1;
            }else if(target>matrix[row][col]){
                min = middle+1;
            }else {
                return true;
            }
        }
        return false;
    }

        public static void main(String args[]) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };
        // Example 1
        Object x = findKeyUsingBinarySearch(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned: " + x);

        // Example 2
        x = findKeyUsingBinarySearch(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned: " + x);
    }
}
