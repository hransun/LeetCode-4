class Solution {
    public int[] findErrorNums(int[] nums) {
        //this is unsorted
        int dup = -1;
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(!set.add(i)){
                dup = i;
            }
        }
        int miss = -1;
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                miss = i;
                break;
            }
        }
        return new int[]{dup, miss};
    }
}
