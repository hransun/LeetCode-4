class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //sort the array and comprare the differ
        // the length is the distance between first diff and last diff
        int [] array = nums.clone();
        Arrays.sort(array);
        boolean flag = false;
        int start = -1;
        int end = -1;
        for(int i = 0; i < nums.length; i++){
            if(array[i] != nums[i]){
                if(!flag){
                   flag = true;
                   start = i;
                }else{
                    end = i;
                }

            }
        }
        if(end == start){
            return 0;
        }
        return end -start+1;
    }
}
