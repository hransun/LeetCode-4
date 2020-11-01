class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        //dp[i][0]: the longest increasing subsequence that end i-index
        //dp[i][1]: the possibilty to build the the longest increasing subsequence
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int longest = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            int count = 0;
            int prevMax = Integer.MIN_VALUE;
            for(int k = i-1; k >= 0; k--){
                if(nums[k] < nums[i]){
                    if(dp[k][0] > prevMax){
                        count = dp[k][1];
                        prevMax = dp[k][0];
                    }else if(dp[k][0] == prevMax){
                        count += dp[k][1];
                    }
                }
            }
            if(count == 0){
                dp[i][0] = 1;
                dp[i][1] = 1;
            }else{
                dp[i][0] = prevMax+1;
                dp[i][1] = count;
            }
            if(dp[i][0] > longest){
                longest = dp[i][0];
                res = dp[i][1];
            // if there are over two same longest subsequence, add the count together
            }else if(dp[i][0] == longest){
                res += dp[i][1];
            }
        }
        return res;
    }
}
