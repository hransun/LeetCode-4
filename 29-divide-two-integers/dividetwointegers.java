class Solution {
    public int divide(int dividend, int divisor) {
        //sepcial case: overflow case
        // min_integer 比max少一位，所以这种情况下会超届
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //step1: check it's negative or position
        int negative = 0;
        if(dividend < 0){
            negative++;
            dividend = -dividend;
        }
        if(divisor < 0){
            negative++;
            divisor = -divisor;
        }
        int res =0;
        while(dividend-divisor >= 0){
            res++;
            dividend -= divisor;
        }
        if(negative == 1){
            res *= -1;
        }
        return res;
    }
}
