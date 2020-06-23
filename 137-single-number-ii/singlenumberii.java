class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()) {
            if(map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
