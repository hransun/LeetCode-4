class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        helper(graph, list, cur, 0);
        return list;
    }
    private void helper(int[][] graph, List<List<Integer>> list, List<Integer> cur, int level) {
      //为null或者已经travsal整个graph
        if( graph[level].length == 0 || level == graph.length) {
            list.add(new ArrayList<>(cur));
            return;
        }
                for(int i = 0; i < graph[level].length; i++) {
                cur.add(graph[level][i]);
                helper(graph,list,cur,graph[level][i]);
                cur.remove(cur.size() -1);

        }


    }
}
