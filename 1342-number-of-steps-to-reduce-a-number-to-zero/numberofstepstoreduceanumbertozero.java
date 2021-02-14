class Solution {
    public int numberOfSteps (int num) {
        //num change to binary
        // if it's "1" => represent 2 steps
        //first step is -"1", second step is /2 and remove this bit zero
        // if it's "0" => represnet 1 step
        // ie: 90 => 1011010 ==> 2+1+2+2+1+2+1 =?11

        //ex: 53 -> 52 -> 5/26=26
        // 110101 => 110100=>11010
        //for remove the last"1", need two steps

        String binary = Integer.toBinaryString(num);
        int step = 0;
        for(char c: binary.toCharArray()){
            step +=(c-'0')+1;
        }
        //the last step will be over-counted, if the last one is 1, only need one step to become 0, the same if the last one is 0, only need one step to become 0
        return step-1;
    }
}
