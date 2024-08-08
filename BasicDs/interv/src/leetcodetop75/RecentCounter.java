package leetcodetop75;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter(){
        this.queue = new LinkedList<>();
    }

    public int ping(int t){
        queue.add(t);
        while (queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));    // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}
