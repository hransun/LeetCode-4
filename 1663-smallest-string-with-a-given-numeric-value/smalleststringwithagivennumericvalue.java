class Solution {
    public String getSmallestString(int n, int k) {
        //起始为‘a’
        //计算剩余多少值，加上a，即当前的字母
        //T：O(N)
        char[] res  = new char[n];
        k -= n;
        for(int i = n-1; i>= 0; i--){
            res[i] = 'a';
            if(k - 25 > 0){
                res[i] = (char)('a'+ 25);
                k -= 25;
            }else if(k > 0){
                res[i] = (char)('a'+k);
                k = 0;
            }
        }
        return new String(res);
    }
}
