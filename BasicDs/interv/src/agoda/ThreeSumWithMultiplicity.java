package agoda;

import java.util.Arrays;

public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007;
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for(int i = 0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            int newTarget = target - arr[i];
            while (j<k){
                if(arr[j]+ arr[k] < newTarget){
                    j++;
                }else if (arr[j]+arr[k] >newTarget){
                    k--;
                }else{
                    int left = 1, right = 1;
                    while (j<k && arr[j] == arr[j+1]){
                        left++;
                        j++;
                    }
                    while (j<k && arr[k] == arr[k-1]){
                        right++;
                        k--;
                    }
                    if(j == k){
                        count += (long) left *(left-1)/2;
                    }else{
                        count += (long) left *right;
                    }
                    count%=mod;
                    j++;
                    k--;
                }
            }
        }
        return (int) count;
    }

    public static void main(String[] args) {
         ThreeSumWithMultiplicity threeSumWithMultiplicity = new ThreeSumWithMultiplicity();
         int[] n = {1,1,2,2,3,3,4,4,5,5};
        int result  =  threeSumWithMultiplicity.threeSumMulti(n,8);
        System.out.println(result);
    }
}
