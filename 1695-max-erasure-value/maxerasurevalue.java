class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //prefix sum + keep the latest start index
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // Map<number, the index of last appear>
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        int start = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = dp[i-1]+nums[i];
            if(map.containsKey(nums[i])){
                // update start index
                start = Math.max(start,map.get(nums[i]) + 1);
            }
            //update the latest index
            map.put(nums[i],i);
            if(start != 0) {
                // the case that the start has move, need to mins the prefix[start-1]
               res = Math.max(res, dp[i] - dp[start-1]);
            }else{
                res = Math.max(res, dp[i]);
            }

        }
        return res;

    }
}
