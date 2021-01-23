class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //T: O(n^2) S:O(n)
        //dp[i]: the longest divisible subarray that end at index i
        //dp做法类似于300: Longest Increasing Subsequence
        List<Integer> list = new ArrayList<>();
        // the reason to sort the array is for do the divisible check
        //这样大的数可以 % 小的数，这样只要检查num[i]%num[j]即可
        Arrays.sort(nums);
        int index = -1;
        int length = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //有一个元素的时候，也算是符合条件的 ex：[3]
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] > length){
                length = dp[i];
                index = i;
            }
        }
        //把最后一个满足条件的元素先加入
        list.add(nums[index]);
        length--;
        for(int i = index-1; i >=0;i--){
            //从index-1往前找
            //如果dp[i] = length &&能和list的最后加入的元素module，即满足条件加入res中
            if(dp[i] == length && list.get(list.size()-1)%nums[i] == 0){
                list.add(nums[i]);
                length--;
            }
        }
        return list;
    }

}
