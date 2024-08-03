package main.java.algorithms.graphalgos;

import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k){
        Map<Integer, List<int[]>> adjacency = new HashMap<>();
        for(int[] time : times){
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            adjacency.computeIfAbsent(source, key->new ArrayList<>()).add(new int[]{destination,travelTime});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            delays = Math.max(delays,time);
            List<int[]> neighbors = adjacency.getOrDefault(node,new ArrayList<>());
            for(int[] neighbor : neighbors){
                int neighborNode = neighbor[0];
                int neighborTime = neighbor[1];
                if(!visited.contains(neighborNode)){
                    int newTime = time+neighborTime;
                    pq.offer(new int[]{newTime,neighborNode});
                }
            }
        }

        if (visited.size() == n){
            return delays;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] times = {
                { {2, 1, 1}, {3, 2, 1}, {3, 4, 2} },
                { {2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2} },
                { {1, 2, 1}, {2, 3, 1}, {3, 4, 1} },
                { {1, 2, 1}, {2, 3, 1}, {3, 5, 2} },
                { {1, 2, 2} }
        };

        int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
