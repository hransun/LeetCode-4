class Solution {
    public boolean canPartition(int[] nums) {
        //memorization: boolean[index][subsetsum]: 在第index个位置的时候，subsetsum是多少是，是否可以partiton
        //如果不能平均除，不能partition
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }
        int subSetSum = sum/2;
        //这里需要用Boolean，因为如果没有visit过，值是null
        //subsetsum是从1开始算，所以要多加一个1
        Boolean[][] memo = new Boolean[nums.length][subSetSum+1];
        return dfs(nums,0,subSetSum, memo);
    }
    private boolean dfs(int[] nums, int index, int subSetSum, Boolean[][] memo){
        if(subSetSum == 0){
            return true;
        }
        if(index == nums.length || subSetSum < 0){
            return false;
        }
        if(memo[index][subSetSum] != null){
            return memo[index][subSetSum];
        }
        boolean res = dfs(nums,index+1,subSetSum, memo) || dfs(nums, index+1,subSetSum-nums[index], memo);
        memo[index][subSetSum] = res;
        return res;
    }
}
