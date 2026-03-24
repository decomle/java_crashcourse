package test.dsa.graph;

class IslandCounter {

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid.length; col++) {
                if(!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    dfs(grid, visited, row, col);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if(grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(IslandCounter.numIslands(grid));;
    }
}