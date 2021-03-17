class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i]: the min coins that can make up for the i amount
        //dp[i] = Math.min(dp[i], dp[i-value of coins]+1)
        //dp[i] start from 0; inint dp element to amount+1 as the max init element
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(i-coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1? -1: dp[amount];

    }
}
