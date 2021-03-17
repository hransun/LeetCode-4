class Solution {
    public int longestPalindromeSubseq(String s) {
        //int[j][i][k]: the longest palidrome that  from j to i and wrap by char k
        int[][][] dp = new int[s.length()][s.length()][26];
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i-1;j>=0;j--){
                //when i and j close to each other and equals
                //this is the start point of palidrome
                if(j == i-1 && s.charAt(i) == s.charAt(j)){
                        dp[j][i][s.charAt(i)-'a'] = 2;
                        max = Math.max(max, 2);
                        continue;
                }
                // check the wrap characters is diff with the previous wrap chars
               for(int k=0;k<26;k++){
                   //if the cur pair is palidrome and wrap chars is differ with prev wrap chars, update max
                        if(s.charAt(i) == s.charAt(j) && s.charAt(i) - 'a' != k){
                            dp[j][i][s.charAt(i)-'a'] = Math.max(dp[j+1][i-1][k] + 2, dp[j][i][s.charAt(i)-'a']);
                            max = Math.max(max, dp[j][i][s.charAt(i)-'a']);
                        }else{
                            // if not, update dp[j][j][k] with previous ans
                            dp[j][i][k] = Math.max(dp[j][i][k], dp[j][i-1][k]);
                            dp[j][i][k] = Math.max(dp[j][i][k], dp[j+1][i][k]);
                            dp[j][i][k] = Math.max(dp[j][i][k], dp[j+1][i-1][k]);
                        }

               }
            }

        }
        return max;
    }
}
