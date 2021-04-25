class Solution {
    public int missingNumber(int[] arr) {
        int diff = arr[1]-arr[0];
        for(int i = 2; i < arr.length; i++){
            int cur = arr[i] - arr[i-1];
            if(cur == 2*diff){
                return arr[i-1]+diff;
            }else if(diff == 2*cur){
                return arr[i-1]-cur;
            }
        }
        return -1;
    }
}
