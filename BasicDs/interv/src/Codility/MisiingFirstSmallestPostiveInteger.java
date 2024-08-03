package Codility;

public class MisiingFirstSmallestPostiveInteger {
    public static int solution(int[] A){
        int n = A.length;
       int[] counter = new int[n+1];
       for (int i : A){
           if(i>0 && i<=n){
               counter[i]++;
           }
       }
       for(int i =1; i<n+1; i++){
           if(counter[i] == 0){
               return i;
           }
       }
       return n+1;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,3,6,4,1,2}));
//        System.out.println(solution(new int[]{1,2,3}));
        System.out.println(solution(new int[]{2}));
    }
}
