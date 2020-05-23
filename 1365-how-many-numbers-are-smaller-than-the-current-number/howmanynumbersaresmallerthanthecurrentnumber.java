class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //T: O(n) S: O(n)
        //in the count, record how many number is smaller than this number
        if(nums == null || nums.length == 0) {
            return new int[]{-1};
        }
        int[] res = new int[nums.length];
        // the number in the array is [0,100]
        int[] count = new int[101];
        for(int i = 0; i < nums.length ; i++) {
            count[nums[i]]++;
        }
        //calculate the accumulated number
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }
        // be careful. the case of 0 doesn't exist in the accumulated count
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                res[i] = 0;
            }else{
            //the ans is in the one element before the num
                res[i] = count[nums[i] - 1];
            }
        }
        return res;
    }

}
