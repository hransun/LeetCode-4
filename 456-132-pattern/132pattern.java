class Solution {
    public boolean find132pattern(int[] nums) {
        //linear scan find the min value for the nums[i]
        // use stack to find the next min value from right to left
        if(nums.length <= 2){
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums.length - 1; i >= 1; i--){
            // 已经满足了 nums[i] < nums[k]  条件，去找右边是否满足nums[k] < nums[j]
            if(nums[i] > min[i]){
                //先pop出不符合要求的情况，即 nums[j] <= nums[i]
                while(!stack.isEmpty() && stack.peek() <= min[i]){
                    stack.pollFirst();
                }
                //符合条件，return true
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.offerFirst(nums[i]);
            }
        }

        return false;
    }
