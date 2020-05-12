class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) {
            return false;
        }
        int left = 1;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int res = num/mid;
            int mod = num%mid;
            if(mod == 0 && res == mid) {
                return true;
            }else if (res < mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

}
