class Solution {
    public int[] constructArray(int n, int k) {
        //base diff is 1
        //ex: 1,2,3,....n
        // 如果 k >=2,从头开始建立
        //ex： k = 3
        // res： 1， 10，2，3，4，。。。9
        // ex：k = 4
        // res: 1,10,2,9,8,7,...1
        // when k = odd, print the remain in increasing odd
        // when k = even, print the remain in the decreasing odd
        // swap order number = k -1; and the odd index is oddone increasing from 1
        //the evenindex is even one, decreasing from 10
        int[] res = new int[n];
        int even = 1;
        int odd = n;
        //建立开头的几个数字
        int index = 0;
        int num = k;
        while(num > 1){
            if(index%2 == 0){
                res[index++] = even++;
            }else{
                 res[index++] = odd--;
            }
            num--;
        }
        if(k % 2 == 1){
            for(int i = index; i < n; i++){
                res[i] = even++;
            }
        }else{
             for(int i = index; i < n; i++){
                res[i] = odd--;
            }
        }
        return res;
    }
}
