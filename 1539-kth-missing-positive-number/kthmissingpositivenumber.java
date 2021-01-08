class Solution {
    public int findKthPositive(int[] arr, int k) {
        //找到前后缺失的数字
        //注意两个数相减，要多减一个1
        int count = 0;
        int prev = 0;
        for(int i = 0; i < arr.length; i++){
            if(prev +1 != arr[i]){
                count += (arr[i] - prev-1);
                if(count >= k){
                    return arr[i] - (count-k) -1;
                }
            }
            prev = arr[i];
        }
        return prev + (k-count);
    }
}
