class Solution {
    public int smallestRangeII(int[] A, int K) {
        //贪心算法
        // min X|Y max， 要y>k
        // 每次扫描拿X，y两个数字，然后更新最新的min和max,然后更新diff
        // 可能的最小值：min+k或者 y-k
        //可能的最大值： max-k或者x+k
        //因为要找diff最小，就要想办法将min和max的互相靠拢，所以min+k，或者y-k为当前可能的min；max-k 或者x+k为当前的min
        Arrays.sort(A);
        int diff = A[A.length-1] - A[0];
        for(int i = 0; i < A.length-1; i++){
            int min = Math.min(A[0]+K,A[i+1]-K);
            int max = Math.max(A[A.length-1]-K,A[i]+K);
            diff = Math.min(diff, max-min);
        }
        return diff;
    }
}
