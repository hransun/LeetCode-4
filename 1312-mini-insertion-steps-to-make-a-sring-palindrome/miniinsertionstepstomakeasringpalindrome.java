class Solution {
    public int minInsertions(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }
        return s.length() - dp(s);
    }
    private int dp(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length() -1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length() -1];
    }
}
