class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] index = new int[]{1};
        helper(res,0,n,index);
        return res;
    }
    private void helper(int[][] res, int k, int n,int[] index){
        if(k >= n/2){
            if(n%2 == 1){
                 res[k][k] = index[0];
            }
            return;
        }
        for(int i = k; i < n-k-1;i++){
            res[k][i] = index[0];
            index[0]++;
        }
        for(int i = k; i < n-k-1;i++){
            res[i][n-k-1] = index[0];
            index[0]++;
        }
        for(int i = n-k-1; i > k; i--){
            res[n-k-1][i] = index[0];
            index[0]++;
        }
        for(int i = n-k-1; i > k;i--){
            res[i][k] = index[0];
             index[0]++;
        }
        helper(res,k+1,n,index);
    }
}
