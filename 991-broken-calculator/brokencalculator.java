class Solution {
    public int brokenCalc(int X, int Y) {
        //从大到小找
        //terminate condition： x>=Y, 之后算差值即可
        int res = 0;
        while(X < Y){
            if(Y%2 == 1){
                Y++;
            }else{
                Y /= 2;
            }
            res++;
        }
        return res+(X-Y);
    }
}
