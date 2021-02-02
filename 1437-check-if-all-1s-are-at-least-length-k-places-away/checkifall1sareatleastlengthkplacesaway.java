class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        boolean visited = false;
        for(int i: nums){
            if(i == 1){
                if(!visited){
                    visited = true;
                }else{
                    if(count < k){
                        return false;
                    }
                }
                count = 0;
            }else{
                count++;
            }
        }
        return true;
    }
}
