package Codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class VoraciousFish {
    public static int solution(int[] A, int[] B){
       Deque<Integer> liveFish = new ArrayDeque<>();
       for(int i =0; i< A.length; i++){
           if(liveFish.isEmpty()){
               liveFish.push(i);
           }else{
               while (!liveFish.isEmpty() && B[i]- B[liveFish.peek()] == -1 && A[liveFish.peek()] < A[i] ) {
                   liveFish.pop();
               }
                   if (liveFish.isEmpty()) {
                       liveFish.push(i);
                   }
                   else if( B[i]-B[liveFish.peek()] != -1) liveFish.push(i);
           }
       }
       return liveFish.size();
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        System.out.println(solution(A,B));
    }
}
