class Solution {
    public int smallestDivisor(int[] nums, int threshold)
    // maximum divisor to consider is max(nums) because the threshold >= num.length
        int max = 1;
        for(int i : nums){
           max= Math.max(max, i);
        }
        int left = 1;
        int right = max;
        int res = 1;
        while(left < right-1){
            int mid = left + (right - left)/2;
            int cur = getSum(mid, nums);
            if(cur <= threshold){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        int t1 = getSum(left, nums);
        if(t1 <= threshold){
            return left;
        }
        return right;

    }
    private int getSum(int div, int[] nums){
        int sum = 0;
        for(int i: nums){
            sum += (int)Math.ceil(i*1.0/div);
        }
        return sum;
    }
}
