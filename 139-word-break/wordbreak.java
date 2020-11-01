class Solution {
  //T: O(n^3) S: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(wordDict.contains(s.substring(0,i+1))){
                dp[i] = true;
                continue;
            }
            for(int k = i- 1; k >= 0; k--){
              //每一次的空间复杂度是max O(n)
              //每出一次循环，substring没有指针指着，空间直接释放，不会累计
                if(dp[k] == true && wordDict.contains(s.substring(k+1,i+1))){
                    dp[i] = true;
                }
            }

        }
        return dp[s.length()-1];
    }
}
