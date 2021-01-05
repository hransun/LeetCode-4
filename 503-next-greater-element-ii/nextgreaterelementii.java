class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //T: O(n^2) - bruce force
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0 ;i < nums.length; i++){
            res[i] = find(nums[i], nums, i);
        }
        return res;
    }
    private int find(int target, int[] array, int index){
        int count = 0;
        int n = array.length;
        while(count < n){
            if(array[(index+count)%n] > target){
                return array[(index+count)%n];
            }
            count++;
        }
        return -1;
    }
}
// stack
//T： O(n)
        //从后扫描array两次, 因为第一次扫描可能会每有扫到在这个element之前比他大的element
    // stack<index>
        int[] res = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 2*nums.length-1; i >=0;i--){
            //如果stack里面的数比但前element小，直接poll出
            while(!stack.isEmpty() && nums[stack.peekFirst()] <= nums[i%nums.length]){
                stack.pollFirst();
            }
            if(stack.isEmpty()){
                res[i%nums.length] = -1;
            }else{
                res[i%nums.length] = nums[stack.peekFirst()];
            }
            stack.offerFirst(i%nums.length);
        }
        return res;
    }
