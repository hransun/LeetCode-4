class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 0) {
            return false;
        }
        return (Math.log(num) / Math.log(4)) % 1 ==0;
    }
}
// for loop, not call api
public boolean isPowerOfFour(int num) {
        if(num <= 0) {
            return false;
        }
        while(num > 1){
            int res = num%4;
            if(res != 0) {
                return false;
            }
            num /= 4;
        }
        return true;

    }
