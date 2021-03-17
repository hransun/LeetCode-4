class Solution {
    public int maxProfit(int[] prices, int fee) {
      //dp[i][0]: the max profit when does not has stock
      //dp[i][1]: the max profit when has stock
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i][0], Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee));
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i-1][1], dp[i-1][0]-prices[i]));
        }
        return dp[prices.length-1][0];
    }
}
