class Solution {
     public int[] distributeCandies(int candies, int n) {
        int round = 0;
        int[] res = new int[n];
        while(candies > 0) {
            int sum = 0;
                for(int i = 0; i < n; i++){
                    int temp = (1+ n*round) + i;
                    if(sum + temp > candies) {
                        res[i] += candies-sum;
                        return res;
                    }
                    res[i] += temp;
                    sum += temp;
            }
            candies -= sum;
            round++;
        }
        return res;
    }
}
