package Codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dominator {
    public static int solution(int[] A){
        int n = A.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        Map<Integer, List<Integer>> leaderMap = new HashMap<>();
        for(int i =0; i< n; i++){
            int num = A[i];
            if (leaderMap.containsKey(num)){
                List<Integer> integers = leaderMap.get(num);
                integers.add(i);
                leaderMap.put(num,integers);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                leaderMap.put(num,list );
            }
        }
        int half = n/2;
        for(Integer key : leaderMap.keySet()){
            if(leaderMap.get(key).size() > half){
               return leaderMap.get(key).get(0);
            }
        }
        return -1;
    }

     /*  If the leader is contained in more than n/2 elements,
        we can remove pairs of different elements from the array
        and the leader will be left in the array. I.e. in worst case
        the leader element will pair with each of other elements and
        only one leader element will be left behind.
        We could use a stack structure to keep the elements are left
        behind, but since we know that in this stack all the elements
        will be the same value (candidate for the leader), we don't
        actually need to create a stack, we just keep the value of
        the candidate for the leader and number of theese elements in
        our stack.
        With the second iteration through the array we just count number
        of occurences of our left behind value  */

    public static int solnAlternative(int[] A){
        int n = A.length, size = 0, value = 0;
        // Phase 1: Find a candidate for the leader
        for(int i =0; i< n; i++){
            if(size == 0){
                size++;
                value = A[i];
            }else {
                size+=(value == A[i]) ? 1 : -1;
            }
        }
        //If No candidate found
        if(size <=0){
            return -1;
        }
        int leader = -1;
        int counter = 0;

        //Phase 2 verify the candidate
        for (int i =0; i<n; i++){
            if(A[i] == value){
                counter++;
                if(leader == -1){
                    leader = i;
                }
            }
        }

        //Return the index of the leader if it exist, otherwise return -1;
        return (counter>n/2) ? leader: -1;
    }

    public static void main(String[] args) {
        int[] A = {3,4,3,2,3,-1,3,3};
        System.out.println(solnAlternative(A));
    }
}
