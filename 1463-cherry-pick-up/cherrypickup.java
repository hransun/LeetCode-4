class Solution {
    public int cherryPickup(int[][] grid) {
        //需要考虑到两个rob同时移动，所有有9个branch
        //两个rob的x坐标是一样的
        // dp: 从botoom走到x，y1,y2的之前的最大cheery数量，包括当前层
        //dfs是down to top
        //这里不需要backtrack因为没有改变grid的值
        Integer dp[][][] = new Integer[grid.length][grid[0].length][grid[0].length];
        return dfs(grid,0,0,grid[0].length-1, dp);
    }
    private int dfs(int[][] grid, int x, int y1, int y2, Integer[][][] dp){
        // out of bound, 往上返0；
        if(x < 0 || x >= grid.length || y1 < 0 || y2 < 0 || y1 >= grid[0].length || y2 >= grid[0].length){
            return 0;
        }
        //之前已经走过，直接读数据
        if(dp[x][y1][y2] != null){
            return dp[x][y1][y2];
        }
         //不包含当前层，之前层的最大cherry数量
        int maxCherry = 0;
        //y 有三个选择，-1， 0， 1
        // 有两个y，所以需要两层loop
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                maxCherry = Math.max(maxCherry, dfs(grid, x+1,y1+i,y2+j,dp));
            }
        }
        int cur = grid[x][y1];
        if(y1 != y2){
            cur += grid[x][y2];
        }
        dp[x][y1][y2] = cur + maxCherry;
        return dp[x][y1][y2];
    }
}
