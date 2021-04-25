class Solution {
    //DFS memorialzaion
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(nums, target, map);
    }
    private int dfs(int[] array, int target, Map<Integer,Integer> map){
        if(target == 0){
            return 1;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        if(target < 0){
            return 0;
        }
        int res = 0;
        for(int i : array){
            int temp = target - i;
            int sum = dfs(array, temp, map);
            //走到这里map一定不存在，直接跟新map即可
            map.put(temp, sum);
            res += sum;
        }
        return res;
    }
}
//dp:
public int combinationSum4(int[] nums, int target) {
       //dp[i]: the combination that for the num i
       int[] dp = new int[target+1];
       dp[0] = 1;
       for(int i = 1; i <=target; i++){
           for(int num: nums){
               if(i- num >= 0){
                   dp[i] += dp[i-num];
               }
           }
       }
       return dp[target];
   }
//follow up: if it has negetivate num, it's shall limited the length of combination, otherwise will have infilit loop
