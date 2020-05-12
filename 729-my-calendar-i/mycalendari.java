class MyCalendar {
    private static class Event {
        int delta;
        int time;
        Event(int delta, int time) {
            this.delta = delta;
            this.time = time;
        }
    }
    List<Event> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    //T: O(n) S: O(n)
    public boolean book(int start, int end) {
        if(list.size() == 0) {
            list.add(new Event(1,start));
            list.add(new Event(-1,end));
            return true;
        }
         list.add(new Event(1,start));
         list.add(new Event(-1,end));
        if(valid(list)) {
            return true;
        }
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        return false;
    }
    private static class  MyCompar implements Comparator<Event>{
        @Override
        public int compare(Event e1, Event e2) {
            if(e1.delta == e2.delta && e1.time == e2.time) {
                return 0;
            }
            if(e1.time < e2.time || (e1.delta < e2.delta && e1.time == e2.time)){
                return -1;
            }
            return 1;
        }
    }
    private boolean valid(List<Event> list) {
        List<Event> copy = new ArrayList<>();
         for(int i = 0; i < list.size(); i++) {
             copy.add(list.get(i));
         }
        copy.sort(new MyCompar());
        int count = 0;
        for(Event booking: copy) {
            count +=booking.delta;
            if(count >= 2) {
                return false;
            }
        }
        return true;
    }
}
