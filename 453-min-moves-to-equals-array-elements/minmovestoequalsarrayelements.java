class Solution {
    public int minMoves(int[] nums) {
        //比较每一个元素和最小值的差，相加
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = Math.min(i, min);
        }
        int res = 0;
        for(int i: nums){
            res += (i-min);
        }
        return res;
    }
}
