class Solution {
    public int findMinArrowShots(int[][] points) {
        //sorted by the end point
        //case1 if end > the next start do nothing
        //case2 if end < the next start count++ and update end
        //Integer.compare(a[1],b[1]) incase overlape
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        if(points.length == 0){
            return 0;
        }
        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length;i++){
            if(end < points[i][0]){
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
