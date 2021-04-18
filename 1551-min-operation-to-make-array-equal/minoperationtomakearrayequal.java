class Solution {
    public int minOperations(int n) {
        //ex： 1，3，5， ｜  7，11， 14
        //结果是前半部分和mid的值的差
        // mid = n
        int mid = n;
        int res =0;
        for(int i= 0; i < n/2; i++){
            res += (mid - 2*i-1);
        }
        return res;
    }
}
