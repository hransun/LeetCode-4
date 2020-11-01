class Solution {
    //T: O(1.5n)
    //S: O(n)
    //dp[i]: alice win or not
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                if(dp[i-j*j] == false){ // if one of bob's turn is false, alice wins
                    dp[i] = true;
                    break;
                }
            }
        }
       return dp[n];
    }

}
