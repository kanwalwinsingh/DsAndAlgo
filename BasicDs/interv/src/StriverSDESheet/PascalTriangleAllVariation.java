package StriverSDESheet;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalTriangleAllVariation {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
      if(numRows == 0){
          return triangle;
      }
      //FirstRow
        List<Integer> firstRow = new ArrayList<>();
      firstRow.add(1);
      triangle.add(firstRow);

      for(int i =1; i<numRows;i++){
          List<Integer> prevRow = triangle.get(i-1);
          List<Integer> newRow = new ArrayList<>();

          newRow.add(1); // First element of each row is always 1
          for(int j =1; j<i;j++){
              newRow.add(prevRow.get(j) +prevRow.get(j-1));
          }
          newRow.add(1); // last element is always 1
          triangle.add(newRow);
      }
      return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);
        System.out.println(triangle);
    }

    /**
     * https://leetcode.com/problems/pascals-triangle-ii/description/
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        long value = 1;  // The first elements of the row is always 1
        row.add((int)value);

        for(int i = 1; i<=rowIndex; i++){
            value = value*(rowIndex-i + 1)/i;
            row.add((int)value);
        }
        return row;
    }


}
