class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //sort the array
        //find the overlap period >= duration
        //else,move the smaller end slot
        Arrays.sort(slots1, (a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < slots1.length && j < slots2.length){
            int start = Math.max(slots1[i][0],slots2[j][0]);
            int end = Math.min(slots1[i][1],slots2[j][1]);
            if(end - start >= duration){
                list.add(start);
                list.add(start+duration);
                return list;
            }
            //no overlap or overlap space is not big enough
            if(slots1[i][1] < slots2[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return list;
    }
}
