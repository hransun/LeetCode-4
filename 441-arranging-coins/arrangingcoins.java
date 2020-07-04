class Solution {
    public int arrangeCoins(int n) {
        //find the largest element that smaller or equal to n
        long left = 0;
        long right = n;
        long cur = 0;
        while(left <= right) {
            long m = left + (right - left) / 2;
            cur = m * (m+1) / 2;
            if(cur == n) {
                return (int)m;
            }else if(cur < n) {
                left = m + 1;
            }else {
                right = m -1;
            }
        }
        return (int)right;
    }
}
