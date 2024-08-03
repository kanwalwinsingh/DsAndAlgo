package main.java.heaps.convertmaxheaptomin;

import java.util.Arrays;

public class ConvertMaxHeapToMinHeapSoln {

    //Function to heapify the subtree rooted at the given index
    static int[] minHeapify(int[] maxHeap, int index, int size){
        //Calculate the left and right child indices
        int left = 2*index +1;
        int right = 2*index +2;
        int smallest = index;

        if(left <size && maxHeap[left] <maxHeap[smallest]){
            smallest = left;
        }
        if(right < size && maxHeap[right] < maxHeap[smallest]){
            smallest = right;
        }
        if(smallest != index){
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[smallest];
            maxHeap[smallest] = temp;
            minHeapify(maxHeap,smallest,size);
        }
        return maxHeap;
    }

    //Function to convert the given max heap into a minheap
    static int[] convertMax(int[] maxHeap){
        int size = maxHeap.length;
        for(int i = size/2; i>=0; i--){
            minHeapify(maxHeap, i, size);
        }
        return maxHeap;
    }
    public static void main(String[] args) {
        int[][] max_heaps = {
                {9, 4, 7, 1, -2, 6, 5},
                {468, 397, 361, 336, 324, 318},
                {1000, 800, 500, -900, -1000},
                {5, 4, 3, 2, 1},
                {10, 9, 6, 2, -3, -12, -14}
        };

        for (int i = 0; i < max_heaps.length; ++i) {
            System.out.println((i + 1) + ".\tGiven Max heap: " + Arrays.toString(max_heaps[i]));
            System.out.print("\tConverted Min heap: ");
            int[] min_heap = convertMax(max_heaps[i]);
            System.out.println(Arrays.toString(min_heap));
            StringBuilder dottedLine = new StringBuilder();

            for (int k = 0; k < 100; k++) {
                dottedLine.append("-");
            }

            System.out.println(dottedLine.toString());
        }
    }
}
