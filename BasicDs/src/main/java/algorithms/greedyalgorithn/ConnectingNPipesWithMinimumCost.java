package main.java.algorithms.greedyalgorithn;


import java.util.Arrays;

public class ConnectingNPipesWithMinimumCost {
    public static int minCostUsingSorting(int[] pipes) {
        int cost = 0;
        int n = pipes.length;

        for (int i = 0; i < n - 1; i++) {
            Arrays.sort(pipes); // Sorting the array
            int prev_cost = cost; // store previous cost for later use
            cost = (pipes[i] + pipes[i + 1]); // find current cost
            pipes[i + 1] = cost; // insert in array
            cost = cost + prev_cost; // add with previous cost
        }
        return cost;
    }

    public static int MinCostUsingMinHap(int pipes[], int n ){
        int cost = 0;
        int minmum, secondMinimum;
        MinHeap minHeap = new MinHeap(pipes,n);
        while (!minHeap.SizeIsOne()){
            minmum = minHeap.extractMin();
            secondMinimum = minHeap.extractMin();
            cost +=(minmum+secondMinimum);

            minHeap.insertKey(minmum+secondMinimum);
        }
        return cost;
    }



    public static void main(String[] args) {
        int[] pipes = {4, 3, 2, 6 };
        System.out.println("Total cost for connecting pipes is " + MinCostUsingMinHap(pipes,4));
        int[] pipes1 = {1, 1, 2, 6};
        System.out.println("Total cost for connecting pipes1 is " + MinCostUsingMinHap(pipes1,4));
    }
}
