class Solution {
    public int islandPerimeter(int[][] grid) {
        //T: O(m*n) S: O(1)
        int sum = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return sum;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    sum += checkNei(grid, i, j);
                }
            }
        }
        return sum;
    }
    private int checkNei(int[][] grid, int i ,int j) {
        int res = 0;
        if(i-1< 0 || grid[i-1][j] == 0) {
            res += 1;
        }
        if(i+1 == grid.length || grid[i+1][j] == 0) {
             res += 1;
        }
       if(j-1< 0 || grid[i][j-1] == 0) {
            res += 1;
        }
        if(j+1 == grid[0].length || grid[i][j+1] == 0) {
             res += 1;
        }
        return res;
    }
}
