package main.java.algorithms.unionsetproblems.noofislands;

import javax.sound.midi.MidiFileFormat;
import java.util.Arrays;
import java.util.List;

public class NoOfIslands {
    public static int numOfIslands(List<List<Character>> grid){
        if (grid.size() == 0){
            return 0;
        }
        int rows = grid.size();
        int cols = grid.get(0).size();

        UnionFind unionFind = new UnionFind(grid);

        for (int r =0; r< rows; r++){
            for (int c =0; c< cols; c++){
                if (grid.get(r).get(c) == '1'){
                    if (r+1 < rows && grid.get(r+1).get(c) == '1')
                        unionFind.union(r*cols+c, (r+1)*cols +c);
                    if (c+1 < cols && grid.get(r).get(c+1) == '1')
                        unionFind.union(r*cols+c,r*cols+(c+1));
                }
            }
        }
        int count = unionFind.getCount();
        return count;
    }

    public static void printGrid(List<List<Character>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid.get(i).size() - 1; j++) {
                System.out.print("'" + grid.get(i).get(j) + "', ");
            }
            System.out.println("'" + grid.get(i).get(grid.get(i).size() - 1) + "']");
        }
    }

    public static void main(String args[]) {
        // Example grid
        List<List<Character>> grid1 = Arrays.asList(
                Arrays.asList('1', '1', '1'),
                Arrays.asList('0', '1', '0'),
                Arrays.asList('1', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        List<List<Character>> grid2 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '0', '0', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        List<List<Character>> grid3 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '1', '1', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        List<List<Character>> grid4 = Arrays.asList(
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1')
        );

        List<List<Character>> grid5 = Arrays.asList(
                Arrays.asList('1', '0', '1'),
                Arrays.asList('0', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        List<List<List<Character>>> inputs = Arrays.asList(grid1, grid2, grid3, grid4, grid5);

        for (int i = 0; i < inputs.size(); i++) {
            System.out.println((i + 1) + ".\t Grid: ");
            printGrid(inputs.get(i));
            System.out.println("\n\t Output: " + numOfIslands(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
