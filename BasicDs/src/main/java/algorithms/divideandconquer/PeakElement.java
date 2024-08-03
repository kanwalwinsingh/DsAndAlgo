package main.java.algorithms.divideandconquer;

public class PeakElement {
    public static int findPeek(int[] array){
        //calcualting array length
        int len = array.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return array[0];
        }
        if(array[0] > array[1]){
            return array[0];
        }
        //traversing array
        for(int i =1; i<len-1; i++){
            //if current value is greater than previous and the next value return it
            if((array[i] >= array[i-1] && (array[i] >=array[i+1]))){
                return array[i];
            }
        }
        if (array[len-1] >= array[len-2]){
            return array[len-1];
        }
        return -1;
    }

    //this function is based on the recursive binary search algorithm returning the peak element in the given array
    public static int findPeakRecursive(int low, int high, int size, int array[]){
        // just as in bunary search, we will first find the middle element
        int middle = low+(high-low)/2;
        //If neighbour of the middle element exist, compare them with the element
        if((middle == size-1 || array[middle+1] <= array[middle]) && (middle == 0 || array[middle-1]<=array[middle])){
            return middle;
        }
        //If the left neighbour of middle element is greater, The peek element must be in the left subarray
        else if(array[middle-1] > array[middle] && middle > 0){
            return findPeakRecursive(low, middle-1,size,array);
        }else{
            return findPeakRecursive(middle+1,high,size,array);
        }
    }

    public static int findPeak(int[] arr){
        int n  = arr.length;
        return findPeakRecursive(0,n-1,n,arr);
    }



    public static void main(String args[]) {
        int[] array = { 7, 11, 22, 13, 4, 0 };
        System.out.println("Peak element is: " + findPeak(array));

        int[] array1 = {0,1,2,3,4};
        System.out.println("Peak element is: " + findPeak(array1));
    }
}
