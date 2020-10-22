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
//mysolution
// construct an array with [pickup, passengers][drop off, - passengers]
//sorted by pickup and drop off, be careful if pickup and drop off at the same location
//first drop off, then pick up
int[][] array = new int[2*trips.length][2];
        for(int i = 0; i < trips.length;i++){
            int[] cur = trips[i];
            array[2*i] = new int[]{cur[1],cur[0]};
            array[2*i+1] = new int[]{cur[2], cur[0]*-1};
        }
        Arrays.sort(array, new MyCompare());
        int count = 0;
        for(int[] i: array){
            count += i[1];
            if(count > capacity){
                return false;
            }

        }
        return true;
    }
    private static class MyCompare implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[0]==b[0]&&a[1]==b[1]){
                return 0;
            }
            if(a[0]==b[0] &&a[1]<b[1] || a[0]<b[0]){
                return -1;
            }
            return 1;
        }
    }
