class Solution {
    // input + output = 111.1111
    // x*2 + 1 把1的数量扩展到和num一个数量级
    //corner case: 0(因为input > output)
    public int findComplement(int num) {
        if(num == 0) {
            return 1;
        }
        int x = 1;
        while(num > x) {
            x = x*2 + 1;
        }
        return x - num;
    }
}
