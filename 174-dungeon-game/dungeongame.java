class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //dp[i][j]: the min health points end at i,j
        //induction rule:
        // if min Health < = 0 ==> min[i][j] = 1
        // if min health > 0 > min[i][j] = min Health
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j<= col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //base case
        dp[row][col-1] = 1;
        dp[row-1][col] = 1;

        for(int i = row-1; i >= 0 ; i--) {
            for(int j = col-1; j >=0; j--) {
                int minHealth = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = minHealth >0? minHealth : 1;
            }
        }
        return dp[0][0];
    }
}
