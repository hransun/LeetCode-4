class Solution {
    public int missingNumber(int[] nums) {
      //T：O（n） S：（1）
      //corner case, if all index match, means no missing number during the 0 ～ n-1, so the missing number is n
        boolean meet = false;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            if(index < nums.length){
                nums[index] *= -1;
            }
            if(index == nums.length){
                meet = true;
            }
        }
        if(!meet){
            return nums.length;
        }
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }else if(nums[i] == 0){
                res = i;
            }
        }
        return res;
    }
}
