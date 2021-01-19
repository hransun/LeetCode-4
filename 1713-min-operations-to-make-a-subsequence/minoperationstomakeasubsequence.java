lass Solution {
    public int minOperations(int[] target, int[] arr) {
        //method 1: A.length - longest common subsequce betweeen arr[] A and arr[] B
        // T： O（m*n）  =>超时
        // method2“ longest increase subsequece
        //把B里面在A中出现过的element用A对应的index代替，找到A.length-longest increase subsequce
        //T：O(n^2) ==> 超时
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length; i++){
            map.put(target[i],i);
        }
        List<Integer> common = new ArrayList<>();
        for(int i: arr){
            if(map.containsKey(i)){
                common.add(map.get(i));
            }
        }
        //如果没有common element，直接返回target。length
        if(common.size() == 0){
            return target.length;
        }
        int[] dp = new int[common.size()];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1; i < common.size(); i++){
            int cur = common.get(i);
            for(int j = 0; j< i; j++){
                if(common.get(j) < cur){
                  dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return target.length - max;
    }
    //longest increasing subsequence： nlogn方法： 详见300题
    Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < target.length; i++){
           map.put(target[i],i);
       }
       List<Integer> common = new ArrayList<>();
       for(int i: arr){
           if(map.containsKey(i)){
               common.add(map.get(i));
           }
       }
       if(common.size() == 0){
           return target.length;
       }
       List<Integer> dp = new ArrayList<>();
       for(int i: common){
           if(dp.isEmpty() || dp.get(dp.size() -1) < i){
               dp.add(i);
               continue;
           }
           int left = 0;
           int right = dp.size()-1;
           while(left < right -1){
               int mid = left + (right - left)/2;
               if(dp.get(mid) >= i){
                   right = mid;
               }else{
                   left= mid+1;
               }
           }
           if(dp.get(left) >= i){
               dp.set(left, i);
           }else{
               dp.set(right, i);
           }
       }
       return target.length - dp.size();
   }
}
