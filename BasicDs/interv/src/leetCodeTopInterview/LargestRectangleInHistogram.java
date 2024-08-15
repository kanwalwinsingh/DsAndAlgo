package leetCodeTopInterview;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangle(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int maxHeight = Integer.MIN_VALUE;
        int n = heights.length;
        for (int i = 0; i<n;i++){
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i -stack.peek() -1;
                maxHeight = Math.max(maxHeight,height*width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n-stack.peek() -1;
            maxHeight = Math.max(maxHeight,height*width);
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle area: " + solution.largestRectangle(heights)); // Output: 10
    }
}
