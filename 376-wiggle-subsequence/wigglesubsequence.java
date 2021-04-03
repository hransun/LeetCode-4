class Solution {
    public int wiggleMaxLength(int[] nums) {
        //O(n^2)
        //dp[i][0]: the max length that end at i which is bigger than its previous number
        //dp[i][1] the max length that end at i which is smaller than its previous number
       int[][] dp = new int[nums.length][2];
        for(int i = 0; i < dp.length; i++){
            //init element into 1
            dp[i][0] = 1;
            dp[i][1] = 1;
            int j = i-1;
            //won't get into the loop for the index 0 situation
            while(j >= 0){
                if(nums[j] < nums[i] ){
                    dp[i][0] = Math.max(dp[j][1]+1, dp[i][0]); // the previous number need to smaller than its previous number
                }
                if(nums[j] > nums[i]){
                    dp[i][1] = Math.max(dp[j][0]+1, dp[i][1]);
                }
                j--;
            }
        }
        return Math.max(dp[dp.length-1][1], dp[dp.length-1][0]);
    }
}
