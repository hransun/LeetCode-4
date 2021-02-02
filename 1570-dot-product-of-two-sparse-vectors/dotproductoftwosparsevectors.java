class SparseVector {
    //only need to store the non-zero value map<index, value>
    private Map<Integer, Integer> map = new HashMap<>();
    private int length;
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                map.put(i,nums[i]);
            }
        }
        length = nums.length;
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        int i = 0;
        while(i < length){
            if(map.containsKey(i) && vec.map.containsKey(i)){
                ans += (map.get(i)*vec.map.get(i));
            }
            i++;
        }
        return ans;
    }
}
