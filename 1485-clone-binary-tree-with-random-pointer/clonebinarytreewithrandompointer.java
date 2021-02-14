/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        return deepCopy(root,map);
        //return newRoot;
    }
    private NodeCopy deepCopy(Node root, Map<Node, NodeCopy> map){
        if(root == null){
            return null;
        }
        if(!map.containsKey(root)){
            map.put(root, new NodeCopy(root.val));
        }
        NodeCopy copy = map.get(root);
        //这里的random不需要走recusrion，否则可能会有死循环
        if(root.random != null){
            if(!map.containsKey(root.random)){
            map.put(root.random, new NodeCopy(root.random.val));
            }
            copy.random = map.get(root.random);
        }
        copy.left = deepCopy(root.left, map);
        copy.right = deepCopy(root.right, map);
        return copy;
    }
}
