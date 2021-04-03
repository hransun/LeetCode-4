class UndergroundSystem {
    //Map<startstation-endstation, list of travalTime>
    Map<String, List<Integer>> travalTime;
    //Map<id, (startstation, startTime)>
    Map<Integer, Pair<String, Integer>> startTime;
    public UndergroundSystem() {
        travalTime = new HashMap<>();
        startTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        startTime.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        //updateStartTime
        Pair p = startTime.remove(id);
        String startStation = (String)(p.getKey());
        int startTime = (int)(p.getValue());
        String key = startStation+"-"+stationName;
        if(!travalTime.containsKey(key)){
            travalTime.put(key, new ArrayList<>());
        }
        travalTime.get(key).add(t-startTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        double res = 0.0;
        String key = startStation+"-"+endStation;
        int size = 0;
        for(int i: travalTime.get(key)){
            res += i*1.0;
            size++;
        }
        return res/size;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
