package main.java.heaps;

import java.util.Arrays;

public class MinHeap {

    public static void buildMinHeap(int[] heapArray, int size){
        for(int i = (size-1)/2; i>=0; i--){
            mininfyHeap(heapArray,i,size);
        }
    }

    private static void mininfyHeap(int[] heapArray, int index, int size) {
        int smalllest = index;
        while (smalllest<(size/2)){
            int left = 2*index +1;
            int right = 2*index +2;
            if(left<size && heapArray[left] <heapArray[index]){
                smalllest = left;
            }
            if(right < size && heapArray[right] < heapArray[smalllest]){
                smalllest = right;
            }
            if(smalllest != index){
                int temp = heapArray[index];
                heapArray[index] = heapArray[smalllest];
                heapArray[smalllest] = temp;
                index = smalllest;
            }else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] heapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
         MinHeap.buildMinHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));

    }
}
