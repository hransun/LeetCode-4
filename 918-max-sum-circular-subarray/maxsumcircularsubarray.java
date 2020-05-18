class Solution {
    //case 1: maxSubarry sum in the mid (dp[] maxsubarray sum way to calculate it)
    // case2: maxSubarry sum is at two side() (sum - du[] minsubarray sum)
    // 1 if sum == minsubarray sum --> all elements are negative -> maxsubarray is the ans
    //2. ans = Math.max(maxsubarray, sum - du[] minsubarray sum )
    public int maxSubarraySumCircular(int[] A) {
        //T: O(n) S: O(n)
        if(A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] minDp = new int[A.length + 1];
        int[] maxDp = new int[A.length + 1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            minDp[i+1] = Math.min(minDp[i]+A[i], A[i]);
            min = Math.min(min, minDp[i+1]);
            maxDp[i+1] = Math.max(maxDp[i]+A[i], A[i]);
            max = Math.max(max, maxDp[i+1]);
        }
        // all elments are negative
        if(min == sum) {
            return max;
        }
        return Math.max(max,sum-min);
    }
    class Solution {
    //case 1: maxSubarry sum in the mid (dp[] maxsubarray sum way to calculate it)
    // case2: maxSubarry sum is at two side() (sum - du[] minsubarray sum)
    // 1 if sum == minsubarray sum --> all elements are negative -> maxsubarray is the ans
    //2. ans = Math.max(maxsubarray, sum - du[] minsubarray sum )
    public int maxSubarraySumCircular(int[] A) {
        //T: O(n) S: O(1)
        if(A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }
        int minDp = 0;
        int maxDp = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            minDp = Math.min(minDp+A[i], A[i]);
            min = Math.min(min, minDp);
            maxDp = Math.max(maxDp+A[i], A[i]);
            max = Math.max(max, maxDp);
        }
        // all elments are negative
        if(min == sum) {
            return max;
        }
        return Math.max(max,sum-min);

    }
}
}
