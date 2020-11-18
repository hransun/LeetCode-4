class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] cur: intervals){
            //add the whole interval
            if(cur[1] <= toBeRemoved[0] || cur[0] >= toBeRemoved[1]){
                List<Integer> curIn = new ArrayList<>();
                curIn.add(cur[0]); curIn.add(cur[1]);
                res.add(curIn);
                continue;
            }
            //add the update interval
            //这里需要考虑一种情况【1，6】， removed【3，5】==>所以两边都要同时确认
            if(cur[1] > toBeRemoved[0] && cur[0] < toBeRemoved[0]){
                List<Integer> curIn = new ArrayList<>();
                curIn.add(cur[0]); curIn.add(toBeRemoved[0]);
                 res.add(curIn);
            }
            if(cur[0] < toBeRemoved[1] && cur[1] > toBeRemoved[1]){
                int[] interval = new int[]{toBeRemoved[1], cur[1]};
                List<Integer> curIn = new ArrayList<>();
                curIn.add(toBeRemoved[1]); curIn.add(cur[1]);
                 res.add(curIn);
            }
        }
        return res;
    }
}
