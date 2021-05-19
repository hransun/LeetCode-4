class Solution {
    //T: O(n+klogn): O(n) is get sum
    //S: O(n)
    // 反向做
    //从target推倒到original
    public boolean isPossible(int[] target) {
        //corner case
        if(target.length == 1){
            return target[0] == 1;
        }
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int i: target){
            sum += i;
            maxHeap.offer(i);
        }
        while(!maxHeap.isEmpty()){
            int max = maxHeap.poll();
            // the largest number is one, means every number is one
            if(max == 1){
                return true;
            }
            int rest = sum - max;
            // this situation will only happen when only two elements
            if(rest == 1){
                return true;
            }
            // 最大值是rest的倍数，也不可能 ，ex ： 【2，4】
            // 这里取余数，直接跳过多步的for loop， 把余数放到下一轮
            int r = max%rest;
            if(r == 0 || r == max){
                return false;
            }

            maxHeap.offer(r);
            sum =(sum - max + r);
        }
        return true;

    }
}
