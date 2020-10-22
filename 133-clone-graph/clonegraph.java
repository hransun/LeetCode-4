/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }
        Node newNode = map.get(node);
        for(Node nei: node.neighbors){
            if(!map.containsKey(nei)){
                map.put(nei, cloneGraph(nei));
            }
            newNode.neighbors.add(map.get(nei));
        }
        return newNode;


    }
}
