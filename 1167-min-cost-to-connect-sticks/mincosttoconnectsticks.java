class Solution {
    public int connectSticks(int[] sticks) {
        //pq: keep add the least stick
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: sticks){
            minHeap.offer(i);
        }
        int res = 0;
        while(minHeap.size() > 1){
            int cur = (int)minHeap.poll()+(int)minHeap.poll();
            res += cur;
            minHeap.offer(cur);
        }
        return res;
    }
}
