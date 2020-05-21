class StockSpanner {
    //S: O(n) T: O(1)
    Deque<Integer> stock;
    Deque<Integer> days;
    public StockSpanner() {
        stock = new ArrayDeque<>();
        days = new ArrayDeque<>();
    }

    public int next(int price) {
        int day = 1;
        while(!stock.isEmpty() && stock.peekFirst() <= price) {
            stock.pollFirst();
            day += days.pollFirst();
        }
        stock.offerFirst(price);
        days.offerFirst(day);
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
