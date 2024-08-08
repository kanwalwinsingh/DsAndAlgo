package microsoft;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    // robot class
    private class Robot{
        public boolean move(){
            return false;
        }
        public void turnLeft(){

        }
        public void turnRight(){

        }
        public void clean(){

        }
    }
    private final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private final Set<String>  visited = new HashSet<>();

    private Robot robot;

    public RobotRoomCleaner(Robot robot){
        this.robot = robot;
    }
    public void  cleanRoom(){
        dfs(0,0,0); // Start from initial position (0,0) facing up (direction index 0)
    }

    private void dfs(int x, int y, int direction){
        String pos = x+","+y;
        if(visited.contains(pos)){
            return;
        }
        visited.add(pos);

        // clean the current cell
        robot.clean();

        //Explore all four directions
        for(int i = 0; i<4; i++){
            int newDirection = (direction+i) %4;
            int newX = x + directions[newDirection][0];
            int newY = y+ directions[newDirection][1];
            if(robot.move()){
                dfs(newX,newY,newDirection);
                //BackTrack to the previous cell
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); //Turn right to try the next direction
        }
    }

}
