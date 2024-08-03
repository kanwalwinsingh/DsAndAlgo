package LeetCode;

public class SearchInTwoDMatrix {


    public boolean searchmatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n-1;
        while (left<= right){
            int mid = left+ (right-left)/2;
            int midElement = matrix[mid/n][mid%n];
            if(midElement == target){
                return true;
            }else if(target<midElement){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix =     {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchInTwoDMatrix s = new SearchInTwoDMatrix();
        System.out.println(s.searchmatrix(matrix,3));
    }
}
