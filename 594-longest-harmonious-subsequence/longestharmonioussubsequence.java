class Solution {
    public int findLHS(int[] nums) {
        //Map<num, the number of nums?
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //only need to consider the key+1 situation
        int res = 0;
        for(Map.Entry entry: map.entrySet()){
            int key = (int)(entry.getKey());
            if(map.containsKey(key+1)){
                res = Math.max(res, (int)(entry.getValue()) + map.get(key+1));
            }
        }
        return res;
    }
}
