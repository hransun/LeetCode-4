class Solution {
    public int[][] updateMatrix(int[][] matrix) {
      //bfs
      //s: O(m*n)
      //T: O(row * m*n)
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = bfs(matrix,i,j);
                }
            }
        }
        return matrix;
    }
    private int bfs(int[][] matrix, int i, int j){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(matrix[x][y] == 0){
                    return level;
                }
                if(x+1 < matrix.length && !visited[x+1][y]){
                    queue.offer(new int[]{x+1,y});
                    visited[x+1][y] = true;
                }
                if(y+1 < matrix[0].length && !visited[x][y+1]){
                    queue.offer(new int[]{x,y+1});
                    visited[x][y+1] = true;
                }
                if(y-1 >= 0 && !visited[x][y-1]){
                    queue.offer(new int[]{x,y-1});
                    visited[x][y-1] = true;
                }
                if(x-1 >= 0 && !visited[x-1][y]){
                    queue.offer(new int[]{x-1,y});
                    visited[x-1][y] = true;
                }
            }
            level++;
        }
        return level;
    }
    //dp
    public int[][] updateMatrix(int[][] matrix) {
    //dp: scan twice,from top to bottom-left to right and the opposite, and get the min
    int[][] dp = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 1){
                //从左到右
                int left = Integer.MAX_VALUE;
                //从上到下
                int up = Integer.MAX_VALUE;
               if(i > 0){
                   up = dp[i-1][j];
               }
               if(j > 0){
                   left = dp[i][j-1];
               }
               int res = Math.min(up,left);
               dp[i][j] = res == Integer.MAX_VALUE? res: res+1;
            }

        }
    }
    for(int i = matrix.length-1; i >= 0; i--){
        for(int j = matrix[0].length-1; j>=0;j--){
            if(matrix[i][j] == 1){
                //从右到做
                int right = Integer.MAX_VALUE;
                //从下到上
                int down = Integer.MAX_VALUE;
                if(i < matrix.length-1){
                    down = dp[i+1][j];
                }
                if(j < matrix[0].length -1){
                    right = dp[i][j+1];
                }
                int res = Math.min(right,down);
                if(res != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], res+1);
                }
            }
        }
    }
    return dp;
}
private int bfs(int[][] matrix, int i, int j){
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    visited[i][j] = true;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{i,j});
    int level = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int k = 0; k < size; k++){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if(matrix[x][y] == 0){
                return level;
            }
            if(x+1 < matrix.length && !visited[x+1][y]){
                queue.offer(new int[]{x+1,y});
                visited[x+1][y] = true;
            }
            if(y+1 < matrix[0].length && !visited[x][y+1]){
                queue.offer(new int[]{x,y+1});
                visited[x][y+1] = true;
            }
            if(y-1 >= 0 && !visited[x][y-1]){
                queue.offer(new int[]{x,y-1});
                visited[x][y-1] = true;
            }
            if(x-1 >= 0 && !visited[x-1][y]){
                queue.offer(new int[]{x-1,y});
                visited[x-1][y] = true;
            }
        }
        level++;
    }
    return level;
}
}
