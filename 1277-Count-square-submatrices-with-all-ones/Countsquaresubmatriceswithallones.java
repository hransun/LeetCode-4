class Solution {
    public int countSquares(int[][] matrix) {
        //dp[i][j] = the number of square that matrix[i][j] can make(as matrix[i][j] is the bottom-right)
        //T: O(n^2) S: O(n^2)
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < row;i++) {
            for(int j = 0; j< col; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
}
