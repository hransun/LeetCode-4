class Solution {
    public int minPartitions(String n) {
        //find the max number in the string
        //  2 5 3 4  => number of min binary number is = 5
        //+ 1 1 1 1
        //+ 1 1 1 1
        //+ 0 1 1 1
        //+ 0 1 0 1
        //+ 0 1 0 0

        int res = 0;
        for(char c: n.toCharArray()){
            res = Math.max(res, (c-'0'));
        }
        return res;
    }
}
