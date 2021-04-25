class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //critial connection: 一条边去掉以后，一个graph变成两个
        //如果几个节点是环，这些节点所在的边就不是cirtial connection
        //tarjan 算法
        //step 1: build map, map<node, the list of connection<node>>
        //step2: array, n length: array[i]: the min step that node i meet
        //step2:  from current node, explore all connected node, except for its parent, and return the min step
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildMap(connections,map,n);
        int[] array = new int[n];
        Arrays.fill(array,-1);
        dfs(0,-1,0,array,res,map);
        return res;
    }
    private void buildMap(List<List<Integer>> connections, Map<Integer, List<Integer>> map, int n){
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(List<Integer> cur: connections){
            map.get(cur.get(0)).add(cur.get(1));
            map.get(cur.get(1)).add(cur.get(0));
        }
    }
    private int dfs(int cur, int parent, int level, int[] array, List<List<Integer>> res, Map<Integer, List<Integer>> map){
        array[cur] = level + 1;
        //dfs children node
        for(int i: map.get(cur)){
            // if it's parent, do nothing
            if(i == parent){
                continue;
            // first time to read this node, dfs
            }else if(array[i] == -1){
                array[cur] = Math.min(array[cur], dfs(i, cur, level+1, array, res, map));
            // this node has read before, just update the min step cur node meets
            }else{
                array[cur] = Math.min(array[cur], array[i]);
            }
        }

        //说明这个节点以及他的parent不是在环里，需要放到结果集里面
        if(array[cur] == level +1 && cur != 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(cur); temp.add(parent);
            res.add(temp);
        }
        return array[cur];
    }

}
