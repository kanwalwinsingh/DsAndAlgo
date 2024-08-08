package leetcodetop75;

import Codility.DistinctInInteger;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids){
        Deque<Integer> stack = new ArrayDeque<>();
       for(int asteroid : asteroids){
           if(asteroid > 0){
               stack.push(asteroid);
           }else{
               //Handle colission
               while (!stack.isEmpty() && stack.peek() >0 && stack.peek()<-asteroid){
                   stack.pop();
               }

               if(stack.isEmpty() || stack.peek() <0){
                   stack.push(asteroid);
               } else if(stack.peek() == -asteroid){
                   stack.pop();
               }
           }
       }
       //Convert stack into the array
        int[] result = new int[stack.size()];
       int idx = 0;
       while (!stack.isEmpty()){
           result[idx++] = stack.removeLast();
       }
       return result;
    }

}
