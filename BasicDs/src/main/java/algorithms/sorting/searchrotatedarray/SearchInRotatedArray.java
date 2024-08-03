package main.java.algorithms.sorting.searchrotatedarray;

public class SearchInRotatedArray {
    static int searchRotatedArray(int arr[], int left, int right, int n){
        int mid = (left+right)/2;
        if(n == arr[mid])
            return mid;
        if(right<left){
            return -1;
        }
        if(arr[left]<arr[mid]){ // the left of the array is sorted
            if(n>=arr[left] && n<arr[mid])
                return searchRotatedArray(arr,left,mid-1,n); // search in the left half
            else
                return searchRotatedArray(arr,mid+1,right,n); // search in the right half
        }else if(arr[mid]<arr[right]){ // the right half of the array is sorted
            if(n>arr[mid] && n<=arr[right]){ // if s is between the mid and end value
                return searchRotatedArray(arr,mid+1,right,n);
            }else{
                return searchRotatedArray(arr,left,mid-1,n);
            }
        }else if(arr[left] == arr[mid]){
            if(arr[mid]!=arr[right]){
                return searchRotatedArray(arr,mid+1,right,n);
            }else{
                int result = searchRotatedArray(arr,left,mid-1,n); // search in left
                if(result == -1)
                    return searchRotatedArray(arr,mid+1,right,n);
                else return result;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {40,100,-100,40,0,24,40};
        System.out.println( "The index is: " + searchRotatedArray(arr, 0, 6, -100));
    }
}
