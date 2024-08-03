package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backTrack(result, new ArrayList<>(),n,k,1);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start){
        if(tempList.size() == k){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i =start; i<= n; i++){
                tempList.add(i);
                backTrack(result,tempList,n,k,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = combine(n, k);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
