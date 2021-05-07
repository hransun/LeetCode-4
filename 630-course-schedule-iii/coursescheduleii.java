class Solution {
    public int scheduleCourse(int[][] courses) {
        //sort by the  end days, assending
        // maxHeap<last days>
        // if cur last day + days of sum >= endsDays
        //check maxHeap, if the biggest last day < cur last day, pop and offer, update day of sum
        //in this points, make sure the day of sum is min
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int[] cur: courses){
            int lasts = cur[0];
            int end = cur[1];
            if(lasts + sum <= end){
                maxHeap.offer(lasts);
                sum += lasts;
            //check whether need to pop up the heap
            }else if(!maxHeap.isEmpty() && maxHeap.peek() > lasts){
                sum +=(lasts-maxHeap.poll());
                maxHeap.offer(lasts);
            }
        }
        return maxHeap.size();

    }
}
