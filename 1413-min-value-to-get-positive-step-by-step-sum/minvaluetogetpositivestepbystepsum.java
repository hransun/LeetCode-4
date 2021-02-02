class Solution {
    public int minStartValue(int[] nums) {
        //minValue in the prefixSum
        //ex: -3,2,-3,4,2
        // 走一遍，min prefixSum = -4
        //要满足条件，起始值最少是5
        int minSum = 0;
        int sum = 0;
        for(int i :nums){
            sum += i;
            if(sum < 0){
                minSum = Math.min(sum, minSum);
            }
        }
        //都是非负数
        if(minSum == 0){
            return 1;
        }
        return minSum*-1 +1;
    }
}
