class Solution {
    public int countVowelStrings(int n) {
        //dp[i][j]: the total number of string that the length of string is i, and the last letter is j
        //induction rule: dp[i-1][j] + dp[i][j-1];
        //dp[i-1][j]: 在ith的字母和i-1th字母相同
        //dp[i][j-1]:在ith的字母比i-1th的字母小一位
        //这里j个字母必须要从1开始，因为base case里面要算
        int[][] dp = new int[n+1][6];
        //base case: n == 1
        for(int i = 1; i <= 5; i++){
            dp[1][i] = i;
        }
        for(int i = 2; i <= n; i++){
            //base case: 字母数量只有1
            dp[i][1] = 1;
            for(int j = 2; j <= 5; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][5];
    }
}
