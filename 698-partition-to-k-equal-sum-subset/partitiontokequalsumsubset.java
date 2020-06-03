class Solution {
    //level k 每一个node 的time compliexcy n*（n-1）
    //T: O(n^2*k) S： O(k)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0 ) {
            return false;
        }
        int sum = 0;
        for(int i: nums) {
            sum +=i;
        }
        if(k <= 0 || sum%k != 0 ) {
            return false;
        }
         int[] visited = new int[nums.length];
        return helper(nums, visited, 0, k, 0, sum/k);

    }
    private boolean helper(int[] nums, int[] visited, int start_index, int k, int cur_sum, int target) {
        //剩余一个k,一定能查到，因为sum % k == 0
        //所以提前返回
        if(k == 1) {
            return true;
        }
        //subarray = target， index清0重新查看新的array，有visited过的进不到下一轮循环
        if(cur_sum == target) {
            return helper(nums, visited, 0, k-1, 0, target);
        //subarray > target 直接return false
        }else if(cur_sum > target) {
            return false;
        }
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0) {
                //吃
                visited[i] = 1;
                if(helper(nums, visited, i+1, k, cur_sum + nums[i], target)) {
                    return true;
                }
                //吐
                visited[i] = 0;
            }
        }
        return false;
    }

}
