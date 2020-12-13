class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        //T: O(n) S: O(n)
       //step 1 ： prefixsum
    // dp[i]: 在第i个字母，以M位结尾，L+M的最大值 其中M是固定的值，L位0 -(m-i)之前的最大值
        int[] prefixSum = new int[A.length+1];
        for(int i = 0; i < A.length; i++){
            prefixSum[i+1] += prefixSum[i]+A[i];
        }
        return Math.max(helper(prefixSum, L,M), helper(prefixSum, M,L));
    }
    private int helper(int[] prefixSum, int a, int b){
        int res = Integer.MIN_VALUE;
        int maxA = Integer.MIN_VALUE;
        for(int i = a+b; i < prefixSum.length;i++){
            int curB = prefixSum[i] - prefixSum[i-b];
            maxA = Math.max(maxA,prefixSum[i-b]-prefixSum[i-b-a]);
            res = Math.max(res, curB+maxA);
        }
        return res;
    }
}
