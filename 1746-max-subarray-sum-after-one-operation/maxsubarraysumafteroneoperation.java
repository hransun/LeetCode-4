class Solution {
    public int maxSumAfterOperation(int[] nums) {
        //sum: the maxSum that end at index i without nums[i]*nums[i]
        //curSum: the maxSum that end at index i which might contains(nums[i]*nums[i])
        int sum = nums[0];
        int curSum = nums[0]*nums[0];
        int max = curSum;
        for(int i = 1; i < nums.length; i++){
            curSum = Math.max(nums[i]*nums[i], Math.max(curSum+nums[i], sum+nums[i]*nums[i]));
            sum = Math.max(nums[i], sum+nums[i]);
            max=Math.max(curSum,max);
        }
        return max;
    }
}
