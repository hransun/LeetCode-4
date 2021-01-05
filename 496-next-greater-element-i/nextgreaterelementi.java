class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //T: n*m
        int[] res = new int[nums1.length];
        for(int i = 0; i< nums1.length; i++){
            res[i] = find(nums1[i],nums2);
        }
        return res;
    }
    private int find(int target, int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                while(i < array.length){
                    if(array[i] > target){
                        return array[i];
                    }
                    i++;
                }
            }
        }
        return -1;
    }
}
