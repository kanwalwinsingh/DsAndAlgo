package leetcodetop75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualsRowAndColumn {
    public int equalPairs(int[][] grid) {
        int m = grid.length;
        int count = 0;

        Map<String,Integer> sameValue = new HashMap<>();
        for(int i = 0; i <m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<m; j++){
                sb.append(grid[i][j]).append(",");
            }
            String s = sb.toString();
            sameValue.put(s,sameValue.getOrDefault(s,0)+1);
        }

        for(int k = 0; k<m; k++){
            StringBuilder sb = new StringBuilder();
            for(int l =0; l<m; l++){
                sb.append(grid[l][k]).append(",");
            }
            String s1 = sb.toString();
                count += sameValue.getOrDefault(s1,0);
            }
        return count;
    }
    public static void main(String[] args) {
        EqualsRowAndColumn solution = new EqualsRowAndColumn();

        int[][] grid = {
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        };

        int result = solution.equalPairs(grid);
        System.out.println("Number of equal row and column pairs: " + result);
    }
}
