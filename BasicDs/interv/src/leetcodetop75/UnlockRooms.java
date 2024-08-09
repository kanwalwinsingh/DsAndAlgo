package leetcodetop75;

import java.util.*;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class UnlockRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // push room 0 as it is unlocked

        while (!stack.isEmpty()){
            int room = stack.pop();
            if(visited.contains(room)) continue;
            visited.add(room);


            for(int key: rooms.get(room)){
                if(!visited.contains(key)){
                    stack.push(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public boolean canVisitAllRoomUsingQueue(List<List<Integer>> rooms){
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0); // start with room 0
        visited.add(0);
        while (!queue.isEmpty()){
            int room = queue.poll();
            for(int key : rooms.get(room)){
                if(!visited.contains(key)){
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }
        return visited.size() == n;
    }


    public static void main(String[] args) {
        UnlockRooms solution = new UnlockRooms();

//        // Example 1
//        List<List<Integer>> rooms1 = Arrays.asList(
//                Arrays.asList(1),
//                Arrays.asList(2),
//                Arrays.asList(3),
//                Arrays.asList()
//        );
//        System.out.println(solution.canVisitAllRooms(rooms1)); // Expected output: true

        // Example 2
        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );
        System.out.println(solution.canVisitAllRooms(rooms2)); // Expected output: false
    }
}
