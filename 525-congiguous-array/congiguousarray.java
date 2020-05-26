class Solution {
    public int findMaxLength(int[] nums) {
          //Assume : only contains 1 and 0
        //T: O(n); S:O(n)
        // use map<sum, index(before the valided pair)>
        // check the longest continue array when sum = 1; sum = -1; sum = 0....
        int sum = 0;
        int res = 0;
        if(nums == null || nums.length <= 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // inital condition
        map.put(0,-1);
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] == 1) {
                sum++;
            }else{
                sum--;
            }
            if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
