class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //在array上对drop和pick的location排序
        //scan array
        int[] array = new int[1001];
        int max = 0;
        for(int[] trip: trips){
            array[trip[1]] += trip[0];
            array[trip[2]] -= trip[0];
            max = Math.max(max, trip[2]);
        }
        int cur = 0;
        for(int i = 0; i <= max; i++){
            cur += array[i];
            if(cur > capacity){
                return false;
            }
        }
        return true;
    }
}
