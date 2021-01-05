class Solution {
    public int bitwiseComplement(int N) {
        if(N == 0){
            return 1;
        }
        //用于标记已经看了几位
        //如果看完了，bitPosition = 0
        int bitPosition = N;
        int bit = 1;
        while(bitPosition > 0){
            //相同取0，不同取1
            N ^= bit;
            //从0postion看起来，每判断一位1往左移一位，看下一位
            bit <<= 1;
            //每看完一位，往右移一位
            bitPosition >>= 1;
        }
        return N;
    }
}
