class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
 boolean[][] visited = new boolean[maze.length][maze[0].length];
         return helper(maze, start[0], start[1], destination, visited);
    }
    private boolean helper(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if(i == destination[0] && j == destination[1]){
            return true;
        }
        if(visited[i][j]) {
            return false;
        }
        //中间的过程不需要放入visited里面
        //只有起始和终止的点
        visited[i][j] = true;
        //先4个方向走一步
        int d = i+1;
        int u = i-1;
        int l = j- 1;
        int r = j + 1;
        //go down
        while(d < maze.length && maze[d][j] == 0)  {
            d++;
        }

        //出来的情况要么越界，要么碰墙，都需要退回去一步
        if(helper(maze,d-1,j,destination, visited)){
            return true;
        }
         //go up
        while(u >= 0 && maze[u][j] == 0)  {
            u--;
        }
        if(helper(maze,u+1,j,destination, visited)){
            return true;
        }//go left
        while(l >= 0 && maze[i][l] == 0)  {
            l--;
        }
        if(helper(maze,i,l+1,destination, visited)){
            return true;
        }
        //go right
        while(r < maze[0].length && maze[i][r] == 0)  {
            r++;
        }
        if(helper(maze,i,r-1,destination, visited)){
            return true;
        }
        return false;
    }
}
