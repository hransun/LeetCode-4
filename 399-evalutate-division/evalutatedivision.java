class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Node: another character, the value that character to another character
        //step 1: buid graph map<character, list of<Node>
        //ie: a,b = 2, b,c = 3
        //=> map<b,[<a,1/2>,<c,2>]
        //=> step2 dfs
        // from start to end, sum *= value;
        Map<String, List<Node>> map = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i <queries.size();i++){
            res[i] = helper(queries.get(i).get(0),queries.get(i).get(1), map, new HashSet<>());
        }
        return res;
    }
    static class Node{
        String letter;
        double value;
        Node(String letter, double value){
            this.letter = letter;
            this.value = value;
        }
    }
    private  Map<String, List<Node>> buildGraph(List<List<String>> list, double[] values){
        Map<String, List<Node>> map = new HashMap<>();
        for(int i = 0; i < list.size();i++){
            List<String> cur = list.get(i);
            double val = values[i];
            String a = cur.get(0);
            String b = cur.get(1);
            if(!map.containsKey(a)){
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(new Node(b,val));
            if(!map.containsKey(b)){
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(new Node(a,1/val));
        }
        return map;
    }
    private double helper(String start, String end, Map<String, List<Node>> map,Set<String> visited){
        if(!map.containsKey(start) || visited.contains(start)){
            return -1.0;
        }
        if(start.equals(end)){
            return 1.0;
        }
        visited.add(start);
        List<Node> list = map.get(start);
        for(Node node: list){
            double res = helper(node.letter, end, map, visited);
            if(res != -1.0){
                return res*node.value;
            }
        }
        visited.remove(start);
        return -1.0;
    }
}
