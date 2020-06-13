class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    int i;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        i = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       if(!map.containsKey(val)) {
           return false;
       }
        int index = map.get(val);
        int swapElement = list.get(list.size()-1);
        map.put(swapElement, index);
        swap(list, list.size()-1, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(i == list.size()) {
           i = 0;
        }
         int index = (int)(Math.random()*(list.size()-i));
         int target = list.get(index+i);
         int swapElement = list.get(i);
         map.put(swapElement, index+i);
         map.put(target, i);
         swap(list, index, i);
         i++;
         return target;
       // return list.get(index);

    }
    private void swap(List<Integer> list, int a ,int b) {
        int t1 = list.get(a);
        int t2 = list.get(b);
        list.set(a,t2);
        list.set(b,t1);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
