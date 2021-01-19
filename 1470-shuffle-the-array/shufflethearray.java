class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int i = 0;
        int j = n;
        int index = 0;
        while(j < 2*n){
            res[index++] = nums[i++];
            res[index++] = nums[j++];
        }
        return res;
    }
}
