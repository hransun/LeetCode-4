class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[row][col] : the lowest sum from the bottom to the num at row/col
        //from botton to top

        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i = triangle.size()-2; i >=0; i--){
            for(int index = 0; index < triangle.get(i).size(); index++){
                dp[i][index] = Math.min(dp[i+1][index],dp[i+1][index+1]) + triangle.get(i).get(index);
            }
        }
        return dp[0][0];
    }
}
