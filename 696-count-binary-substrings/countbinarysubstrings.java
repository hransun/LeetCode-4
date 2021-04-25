class Solution {
    public int countBinarySubstrings(String s) {
        //dp[i]: the count substring
        int[] dp = new int[s.length()];
        int numofprev = 0;
        int numofcur = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(i != 0 && cur != s.charAt(i-1)){
                dp[i] = dp[i-1]+1;
                numofprev = numofcur;
                numofcur = 1;
            }else if(i != 0 && cur == s.charAt(i-1)){
                numofcur++;
                if(numofcur <= numofprev){
                     dp[i] = dp[i-1]+1;
                }else{
                    dp[i] = dp[i-1];
                }
            }else if(i == 0){
                numofcur++;
            }
        }
        return dp[s.length()-1];
    }
}
