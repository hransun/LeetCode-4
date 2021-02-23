class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //dp[i]: the number of Arithmetic that end at index i
        // the result is accumlate
        if(A.length <= 2){
            return 0;
        }
        int diff = A[1] - A[0];
        int[] array = new int[A.length];
        int res = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == diff){
                array[i] = array[i-1]+1;
                res += array[i];
            }else{
                diff = A[i]-A[i-1];
            }
        }
        return res;
    }
}
