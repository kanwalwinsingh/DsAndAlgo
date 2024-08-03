package blackrock;

public class LongestIncreasingSubsequence {

    static int max_ref;
    /**
     *  To make use of recursive call, this function must return two things 1) lemgth off lisending wth
     *  element arr[n-1]. we use max_ending here for this purpose 2) overall maximum as the lis may end with
     *  an element beffore ann[n-1] max_ref is used for this purpose. The value off lis of full array of size n
     *  is stored in the max_ref which is our final result
     */
    static int lisR(int[] arr, int n){
        //Base case
        if(n == 1){
            return 1;
        }
        int res, max_ending_here = 1;
        for(int i =1; i <n; i++){
            res = lisR(arr, i);
            if(arr[i-1] < arr[n-1] && res+1 > max_ending_here){
                max_ending_here = res+1;
            }
        }

        if (max_ref < max_ending_here){
            max_ref = max_ending_here;
        }
        return max_ending_here;

    }

    static int lis(int[] arr, int n){
        max_ref = 1;
        lisR(arr,n);
        return max_ref;
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;

        // Function call
        System.out.println("Length of lis is "
                + lis(arr, n));
    }

}
