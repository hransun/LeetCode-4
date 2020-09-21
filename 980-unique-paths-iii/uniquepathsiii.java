class Solution {
    public int uniquePathsIII(int[][] grid) {
        int empty = 0;
        int x = 0;
        int y = 0;
        int[] res = new int[1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    empty++;
                }
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        helper(grid, x, y, visited, res,  empty);
        return res[0];
    }
    private void helper(int[][] grid, int x, int y, boolean[][] visited, int[] res, int empty){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1||visited[x][y]){
            return;
        }
        if(empty == -1 && grid[x][y] == 2){
            res[0]++;
            return;
        }
        visited[x][y] = true;
        helper(grid, x-1,y,visited, res,empty-1);
        helper(grid, x,y-1,visited, res,empty-1);
        helper(grid, x+1,y,visited, res,empty-1);
        helper(grid, x,y+1,visited, res,empty-1);
        visited[x][y] = false;

    }
}
