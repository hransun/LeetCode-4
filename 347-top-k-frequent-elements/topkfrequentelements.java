class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //T: O(n) + O(klogk)
        //S: O(n)
        if(nums == null ||nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new MyCompare());
        int[] res = new int[k];
        for(Map.Entry<Integer, Integer> entry : set) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }else if(minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        for(int i = k-1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
    private static class MyCompare implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            if(e1.getValue() == e2.getValue()) {
                return 0;
            }
            return e1.getValue() < e2.getValue() ? -1 : 1;
        }
    }

}
