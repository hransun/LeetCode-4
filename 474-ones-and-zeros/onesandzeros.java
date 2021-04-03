class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[m][n]: the largest subset that end at 0 = m, 1 = n

        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            //get the num of one and zero for the cur string
            int[] cur = getOneZeros(s);
            for(int i = m; i >= cur[0]; i--){
                for(int j = n; j >= cur[1];j--){
                    //check the max size for dp[one][two] if want to include the cur string
                    dp[i][j] = Math.max(dp[i][j], dp[i-cur[0]][j-cur[1]]+1);
                }
            }
        }
        return dp[m][n];
    }
    private int[] getOneZeros(String s){
        int[] count = new int[2];
        for(char c: s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }
}
