class PhoneDirectory {
    Set<Integer> slot;
    List<Integer> list;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        slot = new HashSet<>();
        list = new ArrayList<>();
        for(int i = 0; i < maxNumbers;i++){
            list.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(list.size() == 0){
            return -1;
        }
        //randomly pick up an index
        int ran = (int)(Math.random()*list.size());
        int num = list.get(ran);
        list.remove(ran);
        slot.add(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !slot.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(slot.contains(number)){
             slot.remove(number);
              list.add(number);
        }

    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
