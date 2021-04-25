class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //T: O(Row*row*col)
        //S:O(row*col)
        //step1: create a prefix sum matrix
        //calcuate the preSum[j] - preSum[i] = target
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j] + matrix[i][j] - dp[i][j];
            }
        }
        int res =0;
        Map<Integer, Integer> map = new HashMap<>();
        //确定上下边 ==> 拍扁的算法
        for(int i = 1; i < dp.length; i++){
            for(int j = i; j < dp.length; j++){
                //每次重置map
                map.clear();
                //初始化 submatrixSum = 0， 次数是1
                map.put(0,1);
                //for loop 左右边界
                for(int k = 1; k < dp[0].length; k++){
                    int sum = dp[j][k]-dp[i-1][k];
                    // sum = preSum[j]
                    if(map.containsKey(sum-target)){
                            res += map.get(sum-target);
                    }
                    //update map
                    map.put(sum, map.getOrDefault(sum,0)+1);
                }
            }
        }
        return res;
    }
}
//laicode 106 变体
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //T: O(r*r*c*c)
        //S:O(row*col)
        //step1: create a prefix sum matrix
        //calcuate the preSum[j] - preSum[i] = target
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j] + matrix[i][j] - dp[i][j];
            }
        }
        int res =0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                for(int k = i; k < dp.length; k++){
                    for(int p = j; p <dp[0].length; p++){
                        int subMatrix = dp[k][p] - dp[k][j-1] - dp[i-1][p] + dp[i-1][j-1];
                        if(subMatrix == target){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
