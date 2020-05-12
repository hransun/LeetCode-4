class MyCalendarTwo {
    static class Event{
        int del;
        int time;
        Event(int del, int time){
            this.del = del;
            this.time = time;
        }
    }
    List<Event> list;
    public MyCalendarTwo() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(list.size() == 0) {
            list.add(new Event(1, start));
            list.add(new Event(-1, end));
            return true;
        }
        list.add(new Event(1, start));
        list.add(new Event(-1, end));
        if(conflict(list) == false) {
            return true;
        }
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        return false;
    }
    private boolean conflict(List<Event> list) {
        List<Event> copy = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            copy.add(list.get(i));
        }
        copy.sort(new MyCompare());
        int count = 0;
        for(Event event: copy) {
            count += event.del;
            if(count >= 3) {
                return true;
            }
        }
        return false;
    }

    private static class MyCompare implements Comparator<Event> {
        @Override
        public int compare(Event e1, Event e2) {
            if(e1.del == e2.del && e1.time == e2.time) {
                return 0;
            }
            if(e1.time < e2.time || (e1.time == e2.time && e1.del < e2.del)) {
                return -1;
            }
            return 1;
        }
    }

}
