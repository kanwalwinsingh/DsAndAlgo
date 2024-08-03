package nikhil_lohia;

import java.util.*;

public class NextGreaterElement {
    public static int[] soln(int[] num1, int[] num2) {
      if(num2.length == 0 || num1.length == 0){
          return new int[0];
      }
        Map<Integer,Integer> numberNGE = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(num2[num2.length-1]);
        numberNGE.put(num2[num2.length-1],-1);

        for (int i = num2.length-2; i>=0; i--){
            if (num2[i] <stack.peek()){
                numberNGE.put(num2[i],stack.peek());
                stack.push(num2[i]);
            }
            while (!stack.isEmpty() && num2[i] > stack.peek()) {
                stack.pop();
            }
                if (stack.isEmpty()){
                    stack.push(num2[i]);
                    numberNGE.put(num2[i],-1);
                }else{
                    numberNGE.put(num2[i],stack.peek());
                    stack.push(num2[i]);
                }
        }
        for (int i =0; i<num1.length; i++){
            num1[i] = numberNGE.get(num1[i]);
        }
        return num1;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(soln(nums1, nums2)));
    }
}
