package main.java.algorithms.twoheaps;

import java.util.*;

public class MaximizeCapital {
    public static int maximizeCapital(int k, int c, int[] profits, int[] capitals) {
        int n = capitals.length;
        int currentCapital = c;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            capitalMinHeap.offer(new int[]{capitals[i], i});
        }
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(profits[j[1]]);
            }
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            int x = profitsMaxHeap.poll();
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }

    public static int maximizedCapitalSingPriorotyQueue(int k, int w, int[] profits, int[] capital) {
        //Store all project with capital at most w

        PriorityQueue<Integer> pq = new  PriorityQueue<>(Collections.reverseOrder());
        //Store the pair of {c(i), i)
        ArrayList<int[]> v = new ArrayList<>();

        //Traverse the vector c
        for (int i = 0; i < capital.length; i++) {
            v.add(new int[] { capital[i], i });
        }

        // Sort the vector v
        Collections.sort(v, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        int j = 0;
        while (k != 0) {
            // if capital is at mos W
            while (j < capital.length && v.get(j)[0] <= w)
            {
                //Add the profit into the priority queue
                pq.add(profits[v.get(j)[1]]);

                //Increment j by one
                j++;
            }
            //If pq is not empty
            if (!pq.isEmpty()) {
                //update the capital w
                w = w + pq.peek();
                //Delete the top of pq
                pq.poll();
            }

            //Decrement K by one
            k--;
        }
        return w;
    }


    public static void main(String[] args) {
        int[] c = {0, 1, 2, 1, 7, 2};
        int[] k = {1, 2, 3, 3, 2, 4};
        int[][] capitals = {
                {1, 1, 2},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };
        for (int i = 0; i < k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\tMaximum Capital earned: " + maximizeCapital( k[i],c[i],profits[i], capitals[i] ));
            System.out.println(Collections.nCopies(100, "-"));
        }
    }
}
