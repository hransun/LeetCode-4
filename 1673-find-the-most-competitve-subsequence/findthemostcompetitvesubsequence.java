class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        //the number we can drop off for comparing
        int additionalCount = nums.length - k;
        for(int i = 0; i <nums.length;i++){
          while(!deque.isEmpty() && deque.peekFirst() > nums[i] && additionalCount > 0){
                deque.pollFirst();
                additionalCount--;
            }
            deque.offerFirst(nums[i]);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = deque.pollLast();
        }
        return res;
    }
}
