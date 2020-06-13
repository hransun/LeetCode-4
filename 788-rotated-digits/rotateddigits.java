class Solution {
    public int rotatedDigits(int N) {
        //T: O(n*K) S: O(1)
        // take out digit one by one and check wehter it's the valid and rotateable digit
        //if one valid, this number is valid
        // valid and rotateable digit: 2,5,6,9
        // must not be include in a number : 3, 4,7
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(isValid(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isValid(int i) {
            boolean isValid = false;
            while(i > 0) {
                int digit = i%10;
                i /= 10;
                if(digit == 5 || digit == 2 || digit == 6 || digit == 9 ) {
                    isValid = true;
                }
                if(digit == 3 || digit == 4 || digit == 7) {
                    return false;
                }
            }
            return isValid;
    }
}
