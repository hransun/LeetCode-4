class Solution {
    public String decodeAtIndex(String S, int K) {
        //不用generate string，直接记size
        //注意这里遇到数字直接看单个数字就行，不需要累积成多位数
        long size = 0l;
        int i = 0;
        for(; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                size++;
            }else{
                size = size*(c-'0');
            }
            // early terminate
            if(size >= K){
                break;
            }
        }
        //从最后停止的index开始往回走
        for(;i >= 0; i--){
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                //如果k能整除size，说明这个字母就是第k个数字
                //否则size--
                if(K%size == 0){
                    return c+"";
                }
                size--;
            }else{
                //如果是数字，首先size/数字，把size减小
                //然后k%size，找到k和size之间差数，更新k
                size /= c-'0';
                K %= size;
            }
        }
        return null;

    }
}
