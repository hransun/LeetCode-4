class Solution {
    public int firstMissingPositive(int[] nums) {
      //the missing number shall be [1,n+1];
        //change into set, the first number not in the set is the missing number
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(i >0){
                set.add(i);
            }
        }
        for(int i =1; i <= nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }

}
