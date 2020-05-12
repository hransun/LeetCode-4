class MyCalendarThree {

   static class Schedule {
        public int time;
        public int delta;
        public Schedule(int time, int delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    List<Schedule> list;
    public MyCalendarThree() {
        list = new ArrayList<>();
    }

    public int book(int start, int end) {
        list.add(new Schedule(start, 1));
        list.add(new Schedule(end, -1));
        return check(list);
    }
    private int check(List<Schedule> list) {
        list.sort(new MyCompare());
        int max = 0;
        int count = 0;
        for(int i = 0; i<list.size(); i++){
            count += list.get(i).delta;
            max = Math.max(max, count);
        }
        return max;
    }
    static class MyCompare implements Comparator<Schedule> {
        @Override
        public int compare(Schedule s1, Schedule s2) {
            if(s1.time == s2.time && s1.delta == s2.delta) {
                return 0;
            }
            if(s1.time < s2.time || s1.time == s2.time && s1.delta < s2.delta) {
                return -1;
            }
            return 1;
        }
    }
}
