class Solution {
  //Scope: [0,n-1] start from length -1; scope[1,n], start from 0
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len && nums[fast] < len) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        return -1;
    }
}
