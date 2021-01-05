//dfs
//数有多少个graph都是1
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i,j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y <0 || y>= grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid,x,y+1);
        dfs(grid,x+1, y);
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
    }
}
//union find
//如果两个node是connected在一起，即都是1， 那么island数量就减1
// T:(m*n)^2
public int numIslands(char[][] grid) {
       int row = grid.length;
       int col = grid[0].length;
       int[] parent = new int[row*col];
       for(int i = 0; i < row*col;i++){
           parent[i] = i;
       }
       int[] res = new int[1];
       for(int i = 0; i < row; i++){
           for(int j = 0; j < col; j++){
               if(grid[i][j] == '1'){
                   res[0]++;
                   //如果是1， 把1和附近的4个元素union在一起
                   union(i,j,grid,parent,res);
               }
           }
       }
       return res[0];
   }
   private void union(int x, int y, char[][] grid, int[] parent, int[] res){
       //如果之前已经union过了。这里就不需要重复减
       //每一个branch call connnected的时间复杂度是n*m
       if(x+1 < grid.length && grid[x+1][y] == '1'){
           if(connected(x,y,x+1,y,grid,parent)){
               res[0]--;
           }
       }
       if(x-1>=0 && grid[x-1][y] == '1'){
           if(connected(x,y,x-1,y,grid,parent)){
               res[0]--;
           }
       }
       if(y-1>=0 && grid[x][y-1] == '1'){
           if(connected(x,y,x,y-1,grid,parent)){
               res[0]--;
           }
       }
       if(y+1 < grid[0].length && grid[x][y+1] == '1'){
           if(connected(x,y,x,y+1,grid,parent)){
               res[0]--;
           }
       }
   }
   private boolean connected(int x1, int y1, int x2, int y2,char[][] grid, int[] parent){
       //二维坐标转化成一维坐标
       int t1 = x1*grid[0].length + y1;
       int t2 = x2*grid[0].length + y2;
       int p1 = find(t1,parent);
       int p2 = find(t2,parent);
       //已经union在一起了
       if(p1 == p2){
           return false;
       }
       //之前没有union过，重新union一次
       parent[p1] = p2;
       return true;
   }
   //T:o(height)- worst: n*m
   private int find(int t, int[] parent){
       if(parent[t] == t){
           return t;
       }
       return find(parent[t], parent);
   }
}
