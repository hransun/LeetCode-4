class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //2sum变体 set
        //int[] reminder的功能如果set/map
        //T: O(n)
        int[] reminder = new int[60];
        int count = 0;
        for(int i: time){
            if(i%60 == 0){
                //查看有多少数有相同的remider，可以进行配对
                count += reminder[0];
            }else{
                count += reminder[60-i%60];
            }
            reminder[i%60]++;
        }
        return count;

    }
}
