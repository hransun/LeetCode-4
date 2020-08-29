class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //dp[i]: 第i天的最小cost
        int[] dp = new int[366];
        //base case dp[0]
        int index = 0;
        for(int i = 1; i < 366; i++) {
            if(index == days.length) {//已经处理完来所有的出行日期的cost
                break;
            }
            if(days[index] != i){ // 如果这天不用出行，cost继承自昨天
                dp[i] = dp[i-1];
            }else{
                int c1 = costs[0] + dp[i-1]; // 买一天票的cost，原累计cost从1天前继承过来
                int c2 = costs[1] + dp[Math.max(0, i-7)]; // 买7天票的cost，原累计cost从7天前继承过来
                    //max(0,i-7) 用于处理头7天不用额外买7天的票
                int c3 = costs[2]+dp[Math.max(0,i-30)];
                dp[i] = Math.min(c1, Math.min(c2,c3));
                index++;
            }
        }
        return dp[days[days.length-1]];
    }
}
