class Solution {
    public int minOperations(int[] nums, int x) {
        //T: O(N) S: O(N)
        //prefixSum 变种题
        // XXX 00 XX
        //case1 : leftSubSum = x
        //case2: leftSubSum + rightSubSum = x
        //case3: rightSubSum = x;
        //Map<rightSubSum, index
        int res = Integer.MAX_VALUE;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int rightSubSum = 0;
        for(int i = length -1;i>=0; i--){
            rightSubSum += nums[i];
            map.put(rightSubSum, i);
            if(rightSubSum == x){
                res = Math.min(res, nums.length - i);
            }
        }
        int leftSubSum = 0;
        for(int i = 0 ;i < nums.length; i++){
            leftSubSum += nums[i];
            if(map.containsKey(x - leftSubSum)){
                int right = map.get(x-leftSubSum);
                //need to check whether the left index is cross the right index
                if(i < right){
                    res = Math.min(res, i + 1 + nums.length - right);
                }

            }
            if(leftSubSum == x){
                res = Math.min(res, i+1);
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
}
