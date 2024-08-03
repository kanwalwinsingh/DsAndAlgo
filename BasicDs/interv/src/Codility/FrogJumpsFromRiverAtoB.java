package Codility;

//https://github.com/vilasha/Codility-Lessons-Java8/blob/master/task08.java
public class FrogJumpsFromRiverAtoB {
    public static int solution(int X, int[] A){
        int  N = A.length;
        int[] counter = new int[N+1];
        for(int time = 0; time< N; time++){
            if(A[time] > 0  && A[time] <=N) {
                counter[A[time]]++;

                if (counter[A[time]] == 1) {
                    X--;
                }
                if (X == 0) {
                    return time;
                }
            }
        }
        if(X<=0){
            return N;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4,new int[] {4}));
    }
}
