package microsoft;

import java.util.HashSet;
import java.util.Set;

public class RobotRmCleanerMock {
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final Set<String> visited = new HashSet<>();

    static class Robot {
        int[][] room;
        int x, y; // Robot's current position
        int direction; // current direction: 0 = up, 1 = right, 2= down, 3 = left

        public Robot(int[][] room, int startX, int startY) {
            this.room = room;
            this.x = startX;
            this.y = startY;
            this.direction = 0;// Initially facing up
        }

        public boolean move() {
            int newX = x, newY = y;
            switch (direction) {
                case 0:
                    newX = x - 1;
                    break; //Move up
                case 1:
                    newY = y + 1;
                    break; // Move right
                case 2:
                    newX = x + 1;
                    break; // Move down
                case 3:
                    newY = y - 1;
                    break; // Move left
            }
            if (newX >= 0 && newX < room.length && newY >= 0 && newY < room[0].length && room[x][y] == 1) {
                x = newX;
                y = newY;
                return true;
            }
            return false;
        }

        public void turnLeft() {
            direction = (direction + 3) % 4;
        }

        public void turnRight() {
            direction = (direction + 1) % 4;
        }

        public void clean() {
            room[x][y] = 2; // Mark the cell as cleaned
        }

        public void printRoom() {
            for (int[] row : room) {
                for (int cell : row) {
                    System.out.print(cell == 0 ? "#" : (cell == 1 ? "." : "C"));
                }
                System.out.println();
            }
        }
    }

    private Robot robot;

     public RobotRmCleanerMock(Robot robot) {
        this.robot = robot;
    }

    public void cleanRoom() {
        dfs(0, 0, 0); // Start from initial position (0,0) facing up (direction index 0)
    }

    public void dfs(int x, int y, int direction) {
        String pos = x + "," + y;
        if (visited.contains(pos)) {
            return;
        }
        visited.add(pos);

        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newX = x + directions[newDirection][0];
            int newY = y + directions[newDirection][1];

            if (robot.move()) {
                dfs(newX, newY, newDirection);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); // Turn right to try the next direction
        }
    }

    public static void main(String[] args) {
        int[][] room = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1}
        };

        Robot robot = new Robot(room, 1, 3); // Starting position is (1, 3)
        RobotRmCleanerMock cleaner = new RobotRmCleanerMock(robot);

        System.out.println("Initial Room:");
        robot.printRoom();

        cleaner.cleanRoom();

        System.out.println("Cleaned Room:");
        robot.printRoom();
    }

}

