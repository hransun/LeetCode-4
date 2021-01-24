class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
      //deque: keep the min elements based on the index order
        Deque<Integer> deque = new ArrayDeque<>();
        //the times we can replace
        int replaceTime = nums.length - k;
        for(int i = 0; i <nums.length;i++){
          //这里不能用== 号，因为要保留尽量多的min value
          //deque的长度可能会比 k长
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
