class Solution {
    public int removeStones(int[][] stones) {
        //graph search： 找到这里matrix里面有多少个联通的graph
        //一个graph只能保留一个stone
        //做多可以删多少个 = sum - num of graph
        //T:(v+e) S:(v+e)
        Map<int[],List<int[]>> map = buildMap(stones);
        int num = 0;
        Set<int[]> set = new HashSet<>();
        for(Map.Entry entry: map.entrySet()){
            int[] cur = (int[])entry.getKey();
            if(set.add(cur)){
                  bfs(cur,set, map);
                  num++;
            }
        }
        return stones.length - num;
    }
    private void bfs(int[] p, Set<int[]> set, Map<int[],List<int[]>> map){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(p);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                List<int[]> nei = map.get(cur);
                for(int[] n: nei){
                    if(set.add(n)){
                        queue.offer(n);
                    }
                }
            }
        }
    }
    private Map<int[],List<int[]>> buildMap(int[][] stones){
        Map<int[], List<int[]>> map = new HashMap<>();
        for(int[] pair: stones){
            map.put(pair, new ArrayList<>());
        }
         for(int i = 0; i < stones.length; i++){
            int curX = stones[i][0];
            int curY = stones[i][1];
            for(Map.Entry entry: map.entrySet()){
                int[] cur = (int[])entry.getKey();
                if( !equals(stones[i], cur) && (cur[0] == curX || cur[1] == curY)){
                    map.get(cur).add(stones[i]);
                }
            }
        }
        return map;
    }
    private boolean equals(int[] a ,int[] b){
        return a[0] == b[0] && a[1] == b[1];
    }

}
