package main.java.algorithms.graphalgos;

import java.util.*;

public class PathInMaze {
    public static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> neighbour = new HashMap<>();
        int cycles = 0;
        for (int[] corridor : corridors){
            int room1 = corridor[0];
            int room2 = corridor[1];
            neighbour.putIfAbsent(room1,new HashSet<>());
            neighbour.putIfAbsent(room2,new HashSet<>());
            neighbour.get(room1).add(room2);
            neighbour.get(room2).add(room1);
            cycles += intersectionLength(neighbour.get(room1), neighbour.get(room2));
        }
        return cycles;
    }

    private static  int intersectionLength(Set<Integer> set1, Set<Integer> set2){
       int count =0;
        for(Integer elem: set1){
            if(set2.contains(elem)){
                count++;
            }
        }
        return count;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nList = {5, 4, 5, 5, 4};
        int[][][] corridorsList = {
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}},
                {{1, 2}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {3, 1}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}, {1, 5}},
                {{1, 2}, {2, 3}, {3, 4}}
        };

        for (int i = 0; i < nList.length; i++) {
            System.out.println((i + 1) + ".\t n: " + nList[i]);
            System.out.println("\t corridors: " + Arrays.deepToString(corridorsList[i]));
            System.out.println("\t cycles: " + numberOfPaths(nList[i], corridorsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
