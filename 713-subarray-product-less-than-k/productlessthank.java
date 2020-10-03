class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //since it's all negative, the subarray will increase
        //using sliding windown, if product in this silding windown is < k
        //all the element+this scope is <k
        if(k <= 1){
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int product = 1;
        while(j < nums.length){
            product *= nums[j];
            while(product >= k && i<nums.length){
                product /= nums[i++];
            }
            count +=(j-i)+1;
            j++;
        }
        return count;

    }
}
