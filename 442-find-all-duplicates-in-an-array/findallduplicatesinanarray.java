class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
         for(int i: nums){
             if(nums[Math.abs(i)-1] < 0) {
                 list.add(Math.abs(i));
             }else {
                 nums[Math.abs(i)-1] *= -1;
             }
         }
        return list;
    }
}
