class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //Map<boundary, time>
        //not including the last boundary
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: wall){
            int sum = 0;
            for(int i = 0; i < list.size()-1; i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        int boundary= 0;
        for(Map.Entry entry: map.entrySet()){
            int times = (int)(entry.getValue());
            boundary = Math.max(boundary, times);
        }
        //the number of bricks
        return wall.size()- boundary;
    }
}
