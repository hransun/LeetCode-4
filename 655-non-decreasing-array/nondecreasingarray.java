class Solution {
    public boolean checkPossibility(int[] nums) {
       //two pass
       // left to right: check the counts that < max
        // right to left: check the counts that > min
       // return true if one of them counts <= 1
        //ex: 094889
        //left to right : count = 3
        // right to left: count = 1
        int max = Integer.MIN_VALUE;
        int leftToRight = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max){
                leftToRight++;
            }
        }
        int min = Integer.MAX_VALUE;
        int rightToLeft = 0;
        for(int i = nums.length-1; i >= 0; i--){
            min=Math.min(min, nums[i]);
            if(nums[i] > min){
                rightToLeft++;
            }
        }
        return leftToRight <= 1 || rightToLeft <= 1;
    }
}
