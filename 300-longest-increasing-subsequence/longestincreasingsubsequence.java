class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i]: the longest increaseing subsequece that end at index i
        //T： O（n^2), s:o(1)
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <i;j++){
                //如果i > j，那么就比较从j开始继承过来的连续increasing sub大还是之前从别的地方继承过来的大
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //dp[i]: the smallest element that the length of Longest Increasing Subsequence is i
        //T： O nlogn, s:o(n)
        //patience sorting
        // 大的卡片叠在小的卡片上
        //如果最新的卡片不大于最上面的卡片，通过binary search找到min element that bigger than cur one，用cur 代替这个卡片
        List<Integer> dp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            //case1: extend the length of longest increasing subsequece
           if(dp.isEmpty() || dp.get(dp.size()-1) < nums[i]){
               dp.add(nums[i]);
               continue;
           }
            //replace the smallest element(bigger or equal than nums[i]) that end at length x
            //binary search
            int left = 0;
            int right = dp.size()-1;
            while(left < right-1){
                int mid = left + (right -left)/2;
                if(dp.get(mid) >= nums[i]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            if(dp.get(left) >= nums[i]){
                dp.set(left, nums[i]);
            }else {
                dp.set(right, nums[i]);
            }
        }
        return dp.size();
    }
}
