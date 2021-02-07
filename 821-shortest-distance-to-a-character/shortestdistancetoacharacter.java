class Solution {
    public int[] shortestToChar(String s, char c) {
        //linear scan from left to right, find the distance
        //linear scan from right to left, find the distance
        //compare these two distance and get the min one
        //T: O(n)
        int[] res = new int[s.length()];
        //这里的初始值需要设置为length，设置为maxvalue会有逻辑问题
        //因为第2个或者倒数第二个的值是在第一个基础上增加的
        Arrays.fill(res, s.length());
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                res[i] = 0;
            }else if(i >0){
                res[i] = res[i-1]+1;
            }
        }
        for(int i = s.length()-1; i >=0; i--){
            if(i < s.length()-1 && s.charAt(i) != c){
                res[i] = Math.min(res[i], res[i+1]+1);
            }
        }
        return res;
    }
}
