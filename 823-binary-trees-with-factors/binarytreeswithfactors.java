class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
       //dp[i]： the number of tree can make as i is the root
        //init every element in the dp[i] as 1, because each element can be a single tree
        //if can make a tree, dp[i] += dp[leftNode]*dp[rightNode]
        //consider the overflow happens
        Long[] dp = new Long[arr.length];
        Arrays.fill(dp, 1l);
        //need to sort from small to big
        Arrays.sort(arr);
        //find the qualifed index in O(1)
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            index.put(arr[i],i);
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j< i; j++){
                //can be the factor
                if(arr[i]%arr[j] == 0 && index.containsKey(arr[i]/arr[j])){
                    int anotherIndex = index.get(arr[i]/arr[j]) ;
                    dp[i] += dp[j]*dp[anotherIndex];
                }
            }
        }
        long res = 0;
        for(long i: dp){
            res += i;
        }
        return (int)(res%1000000007);

    }
}
