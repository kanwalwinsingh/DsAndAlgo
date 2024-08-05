package nikhil_lohia;

//https://leetcode.com/problems/missing-number/description/
public class MissingNumberintheRangeofArray {
    public int missingNumberUsingSumation(int[] nums){
        int n= nums.length;
        int summation = n*(n+1)/2;
        for(int i =0; i<n;i++){
           summation =  summation-nums[i];
        }
       return summation;
    }

    public int missingNumberUsingXor(int[] nums){
        int n = nums.length;
        int allsumXor = 0;
        for(int i =0 ; i<=n; i++){
            allsumXor^=i;
        }
        for(int num : nums){
            allsumXor^=num;
        }
        return allsumXor;
    }

    public static void main(String[] args) {
        MissingNumberintheRangeofArray object = new MissingNumberintheRangeofArray();
        System.out.println(object.missingNumberUsingXor(new int[]{3,0,1}));
    }
}
