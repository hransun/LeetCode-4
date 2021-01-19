class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            int t = k - i;
            //case 1: 有match，update count(配好对), 因为已经配好对，现在i不需要加入map
            if(map.containsKey(t) && map.get(t) > 0){
                count++;
                map.put(t, map.get(t)-1);
            }else{
            //case2: 配对没有成功，i加入map
                map.put(i, map.getOrDefault(i,0)+1);
            }
        }
          return count;
        }
