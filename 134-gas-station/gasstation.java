class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从左出发一个个扫描过来
        //如果当前i不符合要求，那么potiental ans is next i
        //由于答案只有唯一一个，所有第一个gas[i] - cost[i] >0的即是答案
        // post processing:查看index是否valid
        int index = 0;
        int tank = 0;
        int cur = 0;
        for(int i = 0; i <gas.length; i++){
            //总的油量 总的油量<0 ans = -1
            tank +=gas[i]-cost[i];
            //当前油量 当前油量<0 potential ans 是下一个index
            //当前油量 重制为0
            cur += gas[i]-cost[i];
            if(cur < 0){
                index = i+1;
                cur = 0;
            }
        }
       return tank <0?-1:index;
    }
}
