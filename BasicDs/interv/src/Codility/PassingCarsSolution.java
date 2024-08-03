package Codility;

public class PassingCarsSolution {
    public static int solutions(int[] A){
        int counter = 0;
        int backwordCarCounter = 0;
        for(int i =A.length-1; i>=0; i--){
            if (A[i] == 1){
                backwordCarCounter++;
            }else{
                counter +=backwordCarCounter;
            }
            if(counter>1_000_000_000){
                return -1;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(solutions(new int[]{0,1,0,1,1}));
    }
}
