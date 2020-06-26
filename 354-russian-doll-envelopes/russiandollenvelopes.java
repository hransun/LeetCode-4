class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //T: O(n^2) S: O(n)
        //sort
        //dp[i]: the number of increasing subsequence for y
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 1) {
            return 0;
        }
        Arrays.sort(envelopes, new MyCompare());
        int n = envelopes.length;
        int max = 1;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                max =Math.max(max, dp[i]);
            }
        }
        return max;
    }
    static class MyCompare implements Comparator<int[]> {
       @Override
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0] && a[1] == b[1]) {
                return 0;
            }else if(a[0] < b[0] || (a[0] == b[0] && a[1] > b[1])) {
                return -1;
            }
            return 1;
        }
    }
}
