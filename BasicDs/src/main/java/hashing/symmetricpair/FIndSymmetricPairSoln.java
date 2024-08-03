package main.java.hashing.symmetricpair;

import java.util.*;

public class FIndSymmetricPairSoln {
    public static List<List<Integer>> findSymmetric(int[][] nums) {
        Set<List<Integer>> lookup = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        //Traverse throught the given array
        for(int i =0; i<nums.length; i++){
            int first = nums[i][0];
            int second = nums[i][1];
            //Make a pair and reverse pair
            List<Integer> pair = Arrays.asList(first,second);
            List<Integer> reversePair = Arrays.asList(second,first);
            //Check if the reverse pair exist in the set
            if(lookup.contains(reversePair)){
                //Symmetric Pair found, add to the result list
                result.add(pair);
                result.add(reversePair);
            }else {
                //Insert the current pair into the set
                lookup.add(pair);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][][] testCases = {
                {{1, 2}, {4, 6}, {4, 3}, {6, 4}, {5, 9}, {3, 4}, {9, 5}},
                {{1, 2}, {2, 1}, {3, 4}, {5, 5}, {6, 7}},
                {{1, 9}, {9, 1}},
                {{1, 2}, {3, 4}, {5, 6}},
                {{-8, -4}, {7, 7}, {1, 1}, {2, 2}, {-4, -8}}
        };

        int i = 1;
        for (int[][] testCase : testCases) {
            System.out.println(i + ".\tInput Array: " + Arrays.deepToString(testCase));
            List<List<Integer>> symmetric = findSymmetric(testCase);
            System.out.println("\n\tSymmetric pairs: " + symmetric);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i++;
        }
    }

}
