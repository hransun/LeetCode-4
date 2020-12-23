class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        for(int i = 1; i<A.length; i++){
            min = Math.min(min, A[i]);
            max = Math.max(max,A[i]);
        }
        int diff = Math.abs(min-max);
        int kDiff = K*2;
        return diff-kDiff <= 0? 0:diff-kDiff;
    }
}
