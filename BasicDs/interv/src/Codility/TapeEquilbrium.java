package Codility;

public class TapeEquilbrium {
    public static int sollution(int[] A){
        long totalSum = 0, leftSum = 0, localEqu = 0, minEqu = Integer.MAX_VALUE;
        for(int i : A){
            totalSum+=i;
        }
        for (int i = 0; i<A.length; i++){
            leftSum+=A[i];
            localEqu = Math.abs(totalSum-2*leftSum);
            if(localEqu<minEqu && i<A.length-1){
                minEqu = localEqu;
            }
        }
        return (int)minEqu;
    }

    public static void main(String[] args) {
        System.out.println(sollution(new int[]{3, 1, 2, 4, 3}));
    }

}
