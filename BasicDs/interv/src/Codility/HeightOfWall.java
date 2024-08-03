package Codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class HeightOfWall {
    /*  We create a stack structure to contain already
      built heights. If current block is taller than
      the previous block or there is no previous block
      at all, we just add current block to the stack and
      increase the counter of used blocks. Otherwise
      we remove top block from the stack until it matches
      our current height  */
    public static int solution(int[] H){
        Deque<Integer> blockes = new ArrayDeque<>();
        int blockCounter = 0;
        for(int i =0; i<H.length; i++){
            while (!blockes.isEmpty() && blockes.peek()> H[i]){
                blockes.pop();
            }
            if(blockes.isEmpty() || blockes.peek() < H[i]){
                blockCounter++;
                blockes.push(H[i]);
            }
        }
        return blockCounter;
    }

    public static void main(String[] args) {
        int[] H = {8,8,5,7,9,8,7,4,8};
        System.out.println(solution(H));
    }
}
