class FreqStack {
    Map<Integer, Integer> map; // map<int, freq>
    Map<Integer, Deque<Integer>> freq; // map<freq, stack of integet list>
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x,0)+1);
        int frequence = map.get(x);
        if(!freq.containsKey(frequence)){
            freq.put(frequence, new ArrayDeque<>());
        }
        if(maxFreq < frequence){
            maxFreq = frequence;
        }
        freq.get(frequence).offerFirst(x);
    }

    public int pop() {
        int res = freq.get(maxFreq).pollFirst();
        if(freq.get(maxFreq).size() == 0){
            maxFreq--;
        }
        map.put(res, map.get(res)-1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
