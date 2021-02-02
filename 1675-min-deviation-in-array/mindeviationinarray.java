class Solution {
    public int minimumDeviation(int[] nums) {
        //step 1: for all odd number, *2 => become even
        //step2: pop up the max number => update deviation => / 2 => get the smaller number and put back heap
        //step3: put back to the maxHeap, continue find the latest max, unitl the max become odd, then stop
        //注意去重，最后post-processing，还需要更新一次res
        //这个方法超时
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set  = new HashSet<>();
        for(int i: nums){
            if(i%2 ==1){
                i = i*2;
            }
            if(set.add(i)){
                minHeap.offer(i);
                maxHeap.offer(i);
            }
        }
        int res = Math.abs(minHeap.peek()-maxHeap.peek());
        while(maxHeap.peek()%2 == 0){
            int max = maxHeap.poll();
            set.remove((Integer)(max));
            minHeap.remove((Integer)(max));
            if(!minHeap.isEmpty()){
                res = Math.min(res, Math.abs(max - minHeap.peek()));
            }
            max /= 2;
            if(set.add(max)){
                minHeap.offer(max);
                maxHeap.offer(max);
            }
        }
        res = Math.min(res, Math.abs(minHeap.peek()-maxHeap.peek()));
        return res;
    }
}
