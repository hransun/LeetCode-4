class Solution {
    public int monotoneIncreasingDigits(int N) {
        //step 1: 找到第一个不符合条件index
        //step 2: 往前倒退，if cur < prev,之前的数减少
        //从cur的next开始全部变9
        char[] num = (""+N).toCharArray();
        int i =1;
        while(i < num.length && num[i-1] <= num[i]){
            i++;
        }
        // i point the first wrong number
        //这里要查看确认i有没有out of bound，超出来就不用进入来，说明n本身符合要求
        while(i >= 1 && i < num.length && num[i] < num[i-1]){
            i--;
            num[i]--;
        }
        for(int j = i+1; j < num.length; j++){
            num[j] = '9';
        }
        return Integer.parseInt(new String(num));


    }
}
