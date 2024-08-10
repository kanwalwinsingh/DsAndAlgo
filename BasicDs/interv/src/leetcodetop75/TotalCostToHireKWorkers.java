package leetcodetop75;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidate){
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();

        //head worker stores the first k workers.
        // tail workers store at most last k workers without any worker from the first k worker
        for(int i =0; i<candidate; i++){
            headWorkers.add(costs[i]);
        }
        for(int i = Math.max(candidate, costs.length-candidate); i<costs.length; i++){
            tailWorkers.add(costs[i]);
        }
        long answer = 0;
        int nexhead= candidate;
        int nextTail = costs.length-1-candidate;
        for(int i =0; i<k; i++){
            if(tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek()<=tailWorkers.peek()){
                answer+=headWorkers.poll();
                // Only refill the queue if there are worker outside the two queues
                if(nexhead <= nextTail){
                    headWorkers.add(costs[nexhead]);
                    nexhead++;
                }
            }else{
                answer += tailWorkers.poll();
                // only refill the queue if there are workers outside the two queues
                if(nexhead<=nextTail){
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();

        int[] costs1 = {3, 2, 7, 7, 1, 2};
        int k1 = 3;
        int candidates1 = 2;
        System.out.println("Total Cost: " + solution.totalCost(costs1, k1, candidates1)); // Expected output: 7

        int[] costs2 = {1, 2, 4, 1};
        int k2 = 3;
        int candidates2 = 3;
        System.out.println("Total Cost: " + solution.totalCost(costs2, k2, candidates2)); // Expected output: 6
    }
}
