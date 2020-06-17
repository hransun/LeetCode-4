class Solution {
    public int numTrees(int n) {
        // dp[i] = dp[a]*dp[b] , dp[a] represent the nodes of left tree, dp[b] represent the nodes of right tree
        //dp[i] is the sum of the set of dp[a]*dp[b]
        if(n < 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i-1;j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
