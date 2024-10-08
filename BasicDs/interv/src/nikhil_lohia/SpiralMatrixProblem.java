package nikhil_lohia;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixProblem {
    List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while (rowBegin<= rowEnd && colBegin<= colEnd){

            //TraverseRight
            for(int j = colBegin; j<=colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            for(int i = rowBegin; i<=rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin<= rowEnd){
                for (int j = colEnd; j>=colBegin; j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if(colBegin<=colEnd){
                for (int i = rowEnd; i>=rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
