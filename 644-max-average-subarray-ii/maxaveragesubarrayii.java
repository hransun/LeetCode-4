class Solution {
    public double findMaxAverage(int[] nums, int k) {
       //binary search
        //left : min value; right: max value
        // exit condition: left - right <= 10^-5(calculation error, which is told by problem)
        double left = nums[0];
        double right = nums[0];
        for(int i: nums){
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        while(right-left > 0.00001){
            double mid = left + (right-left)/2;
            //如果有存在klength的subarray， 他的average >= mid, return true
            if(check(mid,k, nums)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
    private boolean check(double val, int k, int[] nums){
        //greedy：a0-mid + (a1-mid) + (a2-mid) > 0 =>return true;
        double sum  = 0;
        double preSum = 0;
        double minPreSum = 0;
        for(int i = 0; i <nums.length; i++){
            sum += nums[i] - val;
            //已经满足length ==k的条件
            if(i >= k-1){
                if(sum - minPreSum >= 0){
                    return true;
                }
                //如果不满足条件，计算presum，并在presum里面找出最小的presum
                //用于和sum相减，找到最合适的subarray sum
                //这个方法是greedy的做法
                preSum += nums[i-k+1] - val;
                minPreSum = Math.min(preSum, minPreSum);
            }
        }
        return false;
    }
}
