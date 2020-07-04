class Solution {
    public int numSquares(int n) {
        if(n <= 0) {
            return -1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int sqr = (int) (Math.sqrt(i));
            if(n == sqr * sqr) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for(int j = sqr; j >= 1; j--) {
                dp[i] = Math.min(dp[i], dp[i - j*j]+1);
            }
        }
        return dp[n];
    }

}
