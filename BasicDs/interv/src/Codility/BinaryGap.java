package Codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(Soln(1376796946));
    }
    public static int Soln(int N){
        int finaGap = 0;
        if(N == 1){
            return 0;
        }

        char[] charArray = Integer.toBinaryString(N).toCharArray();
        int tempGap = 0;
        for(int i =0; i< charArray.length; i++){
            if(charArray[i] == '0'){
                tempGap++;
            }else if(charArray[i] == '1'){
                if(finaGap<tempGap) {
                    finaGap = tempGap;
                }
                    tempGap = 0;
                }
            }
        return finaGap;
    }
}
