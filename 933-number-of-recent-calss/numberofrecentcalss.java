class RecentCounter {
    //timeScope: keep time slot that has pint
 Queue<Integer> timeScope;
    public RecentCounter() {
        timeScope = new ArrayDeque<>();
    }

    public int ping(int t) {
        int startTime = t-3000;
        timeScope.offer(t);
        while(timeScope.peek() < startTime){
            timeScope.poll();
        }
        return timeScope.size();
    }

}
