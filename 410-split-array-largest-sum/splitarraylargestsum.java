class Solution {
    public int splitArray(int[] nums, int m) {
        //T: O(n^2) S: o(n)
        //dp[m][i]: end at i index 的array 分出m份，的min的largest subarray sum
        int[][] dp = new int[m+1][nums.length];
        //base case，m=1的时候，没有subarray
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            dp[1][i] = sum;
        }
        //如果m>= 2, 开始不同的可能性
        for(int k = 2; k <=m; k++){
            // right bound, 最小值从k-1kais
            for(int j = k-1; j < nums.length; j++){
                //初始化值位最大
                dp[k][j] = Integer.MAX_VALUE;
                //left bound 从j的左边开始往1走；
                //用来计算右边部分的sum
                //   XXXXYYY
                //       i j
                // [i,j]的sum = sum, m的一刀切在i-1和i之间
                sum = 0;
                for(int i = j; i >= k-1; i--){
                    sum += nums[i];
                    dp[k][j] = Math.min(dp[k][j], Math.max(dp[k-1][i-1], sum));
                }
            }
        }
        return dp[m][nums.length-1];
    }
}
