package leetcodetop75;

public class IsCitiesConnected {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i =0; i<n; i++){
            if(!visited[i]){
                //Start a DFS for each unvisited city
                dfs(isConnected,visited,i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        //Mark the current city as visited
        visited[city] = true;
        for(int j =0; j< isConnected.length; j++){
            if(isConnected[city][j] == 1 && !visited[j]){
                dfs(isConnected,visited,j);
            }
        }
    }

    public static void main(String[] args) {
        IsCitiesConnected solution = new IsCitiesConnected();

        // Example 1
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected1)); // Expected output: 2

        // Example 2
        int[][] isConnected2 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected2)); // Expected output: 2
    }
}
