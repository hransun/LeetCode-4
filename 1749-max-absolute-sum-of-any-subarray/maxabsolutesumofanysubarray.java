public int maxAbsoluteSum(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int sum = Math.abs(nums[0]);
    for(int i = 1; i < nums.length; i++){
        min = Math.min(nums[i], min+nums[i]);
        max = Math.max(nums[i], max+ nums[i]);
        int cur = Math.max(Math.abs(min), Math.abs(max));
        sum = Math.max(sum, cur);
    }
    return sum;
}
}
