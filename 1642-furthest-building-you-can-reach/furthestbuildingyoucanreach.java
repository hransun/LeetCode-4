class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //maxHeap<integer>:keep the bricks for each jump
        // if overall sum > brick, poll out the max interger, and use ladder
        // else, add the number of brick into maxHeap
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < heights.length-1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff <= 0 ){
                continue;
            }
            sum += diff;
            maxHeap.offer(diff);
            if(sum > bricks){
                if(ladders == 0){
                    return i;
                }
                ladders--;
                if(!maxHeap.isEmpty()){
                    sum -= maxHeap.poll();
                }
            }
        }
        return heights.length-1;
    }
}
