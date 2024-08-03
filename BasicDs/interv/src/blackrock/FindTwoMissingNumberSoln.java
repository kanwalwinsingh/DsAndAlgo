package blackrock;

public class FindTwoMissingNumberSoln {

    public static void  findTwoMissingNum(int[] arr, int n) {
        //Create a boolean vector of size n+1 and mark all present elements of arr[] in it
        boolean[] mark = new boolean[n + 1];
        for(int i =0; i< arr.length; i++){
            mark[arr[i]] = true;
        }

        // print two unnmarked element
        System.out.println("The two missing numbers are");

        for(int i =1; i<= n; i++){
            if(!mark[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 3, 5, 6};

        // Range of numbers is 2 plus size of array
        int n = 2 + arr.length;

        findTwoMissingNum(arr, n);
    }

}
