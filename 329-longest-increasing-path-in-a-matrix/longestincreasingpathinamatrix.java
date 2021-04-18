class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //不能用dp做，有些结果不能算出，比如
        // 789
        // 976
        //723
        //无法cover 2-> 3->7->6 ->8 ->9的情况
        int[][] res = new int[matrix.length][matrix[0].length];
        int ans = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ans = Math.max(ans, dfs(matrix,i,j,res,-1));
            }
        }
        return ans;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] res,int prev){
        //如果当前层不符合要求 ，返回0
        if(i <  0|| i>= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        //如果当前层走过，返回结果
        if(res[i][j] > 0){
            return res[i][j];
        }
        //当前层没有走过，计算结果并且cache住结果
        int r1 = dfs(matrix, i+1,j,res,matrix[i][j]);
        int r2 = dfs(matrix, i-1,j,res,matrix[i][j]);
        int r3 = dfs(matrix, i,j+1,res,matrix[i][j]);
        int r4 = dfs(matrix, i,j-1,res,matrix[i][j]);
        //边走边cache
        res[i][j] =  Math.max(r1, Math.max(r2, Math.max(r3,r4)))+1;
        return res[i][j];
    }
}
