package leetcodetop75;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> inHeap;
    private int currentSmallest;

    public SmallestInfiniteSet(){
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
        currentSmallest = 1;
    }

    public int popSmallest(){
        if(!minHeap.isEmpty()){
            int smallest= minHeap.poll();
            inHeap.remove(smallest);
            return smallest;
        }
        return currentSmallest++;
    }
    public void addBack(int num){
        if(num<currentSmallest && !inHeap.contains(num)){
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();

        // Example operations
        System.out.println(set.popSmallest()); // Output: 1
        System.out.println(set.popSmallest()); // Output: 2
        set.addBack(1);                        // Adds 1 back to the set
        System.out.println(set.popSmallest()); // Output: 1
        System.out.println(set.popSmallest()); // Output: 3
        System.out.println(set.popSmallest()); // Output: 4
        set.addBack(2);                        // Adds 2 back to the set
        System.out.println(set.popSmallest()); // Output: 2
    }
}
