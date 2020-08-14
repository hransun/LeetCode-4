class Solution {
    public int orangesRotting(int[][] grid) {
        //bfs
        //find the deepest level start from the rotten organe
        Queue<Pair> queue = new ArrayDeque<>();
        int mini = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int level = pair.level;
            mini = Math.max(mini,level);
                if(row+1<grid.length){
                    if(grid[row+1][col] == 1) {
                        queue.offer(new Pair(row+1,col,level+1));
                        grid[row+1][col] = 2;
                    }
                }
                if(col+1<grid[0].length){
                    if(grid[row][col+1] == 1) {
                        queue.offer(new Pair(row,col+1,level+1));
                        grid[row][col+1] = 2;
                    }
                }
                if(col-1 >= 0){
                    if(grid[row][col-1] == 1) {
                        queue.offer(new Pair(row,col-1,level+1));
                        grid[row][col-1] = 2;
                    }
                }
                if(row-1 >= 0){
                    if(grid[row-1][col] == 1) {
                          queue.offer(new Pair(row-1,col,level+1));
                        grid[row-1][col] = 2;
                    }

                }
            }
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                   return -1;
                }
            }
        }
        return mini;

    }

    static class Pair{
        int row;
        int col;
        int level;
        Pair(int row, int col,int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
}
