package nikhil_lohia;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemprature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n-1] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(n-1);

        for(int i = n-2; i>=0; i--){
            int num = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= num){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
      //  Output: [1,1,4,2,1,1,0,0]
        DailyTemprature dailyTemprature = new DailyTemprature();
        System.out.println(
                Arrays.toString(
          dailyTemprature.dailyTemperatures(temp)));
    }
}
