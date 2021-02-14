class Solution {
    public boolean isBipartite(int[][] graph) {
        //grap: 每一个index代表一个node，每一个graph[i]代表neigbor
        //nodes代表整体的graph
        //先从一个node出发，遍历其相邻的nei
        int[] nodes = new int[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nodes.length; i++){
            //已经被染色过或没有neighbor，跳过
            if(nodes[i] != 0 || graph[i].length == 0){
                continue;
            }
            //init is 1
            nodes[i] = 1;
            queue.offer(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                int color = nodes[cur];
                //traversal the neigbors and color  -1
                for(int j: graph[cur]){
                    if(nodes[j] == 0){
                        nodes[j] = color*-1;
                        queue.offer(j);
                    }else if(nodes[j] != color*-1){
                        return false;
                    }
                }
            }


        }
        return true;


    }
}
