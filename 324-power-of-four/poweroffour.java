class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 0) {
            return false;
        }
        return (Math.log(num) / Math.log(4)) % 1 ==0;
    }
}
