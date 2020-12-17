class Solution {
    public int maxCoins(int[] nums) {
        //T: n! S: o(n)
        //dfs: 每一层任取一个index来打破
        int[] res = new int[]{Integer.MIN_VALUE};
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }
        dfs(list,res,0);
        return res[0];
    }
    private void dfs(List<Integer> list,int[] res, int sum){
        if(list.size() == 0){
            res[0] = Math.max(res[0],sum);
            return;
        }
        for(int i = 0; i < list.size(); i++){
            int curSum = list.get(i);
            int cur = curSum;
            if(i-1 >= 0){
                curSum *= list.get(i-1);
            }
            if(i+1 < list.size()){
                curSum *= list.get(i+1);
            }
            list.remove(i);
            dfs(list,res, sum+curSum);
            list.add(i,cur);
        }
    }
}

//dp
public int maxCoins(int[] nums) {
        //dp[i][j]: from(i,j), which i, j are not including, the max coins it can get
        //induction rule iXXXKXXJ dp[i][j] = dp[i,k-1]+ array[i]*array[k]*array[j] + dp[k+1,j]
        //从最小一个开始算，iKj的乘积+i和k之间会产生的maxcoins+k和j之间会产生的max coins
    int[][] dp = new int[nums.length+2][nums.length+2];
        //创建一个新的array，头尾加1
    int[] array = new int[nums.length+2];
    for(int i = 0; i < array.length; i++){
        if(i == 0 || i == array.length-1){
            array[i] = 1;
        }else{
            array[i]= nums[i-1];
        }
    }
        //从倒数第三个数开始计算
    for(int i = array.length-3; i >= 0; i--){
        for(int j = i+2; j < array.length; j++){
            for(int k = i+1; k < j; k++){
                dp[i][j] = Math.max(dp[i][j], dp[i][k] + array[i]*array[k]*array[j]+dp[k][j]);
            }
        }
    }
    return dp[0][array.length-1];
    }
