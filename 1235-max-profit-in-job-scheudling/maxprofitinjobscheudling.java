class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      //TreeMap
        int[][] job = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            job[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //map: endTime, the sum of profit at the endTime
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        //sort by end time
        Arrays.sort(job, (a,b)->a[1]-b[1]);
        //initial treeMap
        treeMap.put(0,0);
        for(int[] pair: job){
            //floorEntry(pair): end time is less or equal to current start time
            int curProfit = treeMap.floorEntry(pair[0]).getValue() + pair[2];
            //如果目前的profit比最晚end的时候的profit大，加入map
            if(curProfit > treeMap.lastEntry().getValue()){
                treeMap.put(pair[1],curProfit);
            }
        }
        return treeMap.lastEntry().getValue();

    }
    //DP solution
    class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //dp[i]: the max profit end at time i
        int[][] job = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            job[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //sort by end time
        Arrays.sort(job, (a,b)->a[1]-b[1]);
        int[] dp = new int[job.length+1];
        for(int i = 1; i < dp.length; i++){
            //find the end time that smaller or equal to cur start time
            int lastEndTime = binarySearch(job,job[i-1][0]);
            dp[i] = Math.max(dp[i-1], dp[lastEndTime+1]+job[i-1][2]);

        }
        return dp[job.length];
    }
    private int binarySearch(int[][] job, int start){
        int left  = 0;
        int right = job.length-1;
        while(left < right-1){
            int mid = left + (right-left)/2;
            if(job[mid][1] == start){
                return mid;
            }
            if(job[mid][1] > start){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        if(job[right][1] <= start){
            return right;
        }else if(job[left][1] <= start){
            return left;
        }
        return -1;
    }
}
