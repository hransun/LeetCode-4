class Solution {
    //dp[i][j] present the min cost of i person go to city A and j person go to city B
    // induction rule:
    // the cost of  last one who go to city A: dp[i-1][j] + costs[i+j-1][0]
    // the cost of  last one who go to city B: dp[i][j-1] + costs[i+j-1][1]
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length / 2;
        int[][] dp = new int[n+1][n+1];
        //base case: one person only go to either A or B
        for(int i = 1; i <= n;i++) {
            dp[i][0] = dp[i-1][0] + costs[i-1][0];
            dp[0][i] = dp[0][i-1] + costs[i-1][1];
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + costs[i+j-1][0], dp[i][j-1] + costs[i+j-1][1]);
            }
        }
        return dp[n][n];
    }
}
