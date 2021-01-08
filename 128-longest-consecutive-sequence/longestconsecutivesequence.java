class Solution {
    public int longestConsecutive(int[] nums) {
        // T: O(n) S:O(n)
        // slow, fast pointer
        if(nums.length <= 1){
            return nums.length;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            set.add(cur);
        }
        int length = 1;
        int start = min;
        int end = min;
        while(end <= max){
            if(!set.contains(end)){
                length = Math.max(length, end-start);
                while(end <= max && !set.contains(end)){
                    end++;
                }
                start = end;
            }
            end++;
        }
        length = Math.max(length, end-start);
        return length;
    }
}
