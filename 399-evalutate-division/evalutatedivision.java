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
//bfs solution
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //buid the map to reflect the relationship
        //bfs
        Map<String, List<Element>> map = buildMap(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> cur = queries.get(i);
            String start = cur.get(0);
            String end = cur.get(1);
            if(!map.containsKey(start) || !map.containsKey(end)){
                res[i] = -1.0;
            }else{
                res[i] = bfs(map, cur.get(0), cur.get(1));
            }
        }
        return res;
    }
    static class Element{
        String letter;
        double val;
        Element(String letter, double val){
            this.letter = letter;
            this.val = val;
        }
    }
    private Map<String, List<Element>> buildMap(List<List<String>> list, double[] values){
        Map<String, List<Element>> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            List<String> pair = list.get(i);
            double val = values[i];
            if(!map.containsKey(pair.get(0))){
                map.put(pair.get(0), new ArrayList<>());
            }
            map.get(pair.get(0)).add(new Element(pair.get(1), val));
            if(!map.containsKey(pair.get(1))){
                map.put(pair.get(1), new ArrayList<>());
            }
            map.get(pair.get(1)).add(new Element(pair.get(0), 1/val));
        }
        return map;
    }
    private double bfs(Map<String, List<Element>> map, String start, String end){
        Queue<String> queue = new ArrayDeque<>();
        Queue<Double> ans = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        ans.offer(1.0);
        set.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                String cur = queue.poll();
                double prev = ans.poll();
                if(cur.equals(end)){
                    return prev;
                }
                for(Element e: map.get(cur)){
                    String l = e.letter;
                    double v = e.val;
                    if(set.add(l)){
                        queue.offer(l);
                        ans.offer(v*prev);
                    }
                }
            }
        }
        return -1.0;
    }
