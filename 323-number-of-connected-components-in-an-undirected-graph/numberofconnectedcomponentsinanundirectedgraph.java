class Solution {
    public int countComponents(int n, int[][] edges) {
        //the single node not in the edges
        //bfs shall return early
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildMap(map, edges);
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < n ; i++){
            if(set.add(i)){
               res++;
               bfs(i, map, set);
            }
        }
        return res;
    }
    private void buildMap(Map<Integer, List<Integer>> map, int[][] edges){
        for(int[] pair: edges){
            int a = pair[0];
            int b = pair[1];
            if(!map.containsKey(a)){
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
            if(!map.containsKey(b)){
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

    }
    private void bfs(int n, Map<Integer, List<Integer>> map, Set<Integer> set){
        if(!map.containsKey(n)){
            return;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i: map.get(cur)){
                if(set.add(i)){
                    queue.offer(i);
                }
            }
        }
    }
}
