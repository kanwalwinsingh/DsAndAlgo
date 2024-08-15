package leetCodeTopInterview;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // To store the smaller half
    private PriorityQueue<Integer> minHeap; // To store the larger half

    public MedianFinder(){
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num){
       if(maxHeap.isEmpty() || num <= maxHeap.peek()){
           maxHeap.offer(num);
       }else{
           minHeap.offer(num);
       }
       //Balance the heap
        if(maxHeap.size() > minHeap.size() +1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() > minHeap.size()){
            return (double) maxHeap.peek();
        }else{
            return ((double) maxHeap.peek() + (double) minHeap.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // Output: 1.0
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }
}
