class Solution {
    public int reachNumber(int target) {
        //dfs会超时
        //有固定的pattern，正负数是一样的
        //    0     even
        //  /  \
        //  1      odd
        //  ｜ ｜
        //  3  1   odd
        //  ｜｜｜｜
        //  6，0，2，4  even
        // ｜｜｜｜｜｜｜
        // 10 2 4 6 0 8 even
        // patter是两行odd，两行even
        // 找到target的条件是cur >= target &&奇偶性和target相等
        if(target < 0){
            target *= -1;
        }
        int add = 1;
        int cur =0;
        int level = 0;;
        while(cur < target || cur%2 != target%2){
            cur += add;
            add++;
            level++;
        }
        return level;

    }
}
