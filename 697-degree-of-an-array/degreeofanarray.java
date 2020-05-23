class Solution {
    public int findShortestSubArray(int[] nums) {
        // solution: look for the shorest subarray contains all of degree number
        //T: O(n) S: O(n)
        if(nums.length <= 1) {
            return nums.length;
        }
        //Map<num, degree>
        Map<Integer, Integer> map = new HashMap<>();
        //Map<num, the index of first appear>
        Map<Integer, Integer> first = new HashMap<>();
        int res = 0;
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            if(map.get(nums[i]) > degree) {
                // update degree and length
                degree = map.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            }else if(map.get(nums[i]) == degree) {
                // update the shorest length
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
