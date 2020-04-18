class Solution {
    // find the first edge that causes the circle and return the edge
    //T： n+mlogn (m of union-find operations on a set of n object)
    //S: O(n) --> the number of nodes
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0) {
            return null;
        }
        UnionSet set = new UnionSet(edges.length);
        for(int[] nodes: edges) {
            if(!set.union(nodes[0],nodes[1])) {
                return nodes;
            }
        }
        return null;
    }
    class UnionSet{
        int[] parent;
        //rank： the size of tree, the small tree always connect below the big tree
        int[] rank;
        // init parent and rank
        //ex: [[1,2], [2,3], [3,4], [1,4], [1,5]]
        // parent: 1 2 3 4 5
        // rankd:  1 1 1 1 1
        UnionSet(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 1; i<= n;i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public boolean union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            // already under the same root
            // it union again, it will be a circle
            if(pu == pv){
                return false;
            }
            //union
            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu] += 1;
            }
            return true;
        }
        private int findParent(int t) {
            //flat the tree
            //must be while
            while(parent[t] != t) {
                parent[t] = parent[parent[t]];
                t = parent[t];
            }
            return t;
        }
    }
}
