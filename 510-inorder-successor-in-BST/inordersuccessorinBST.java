class Solution {
    public Node inorderSuccessor(Node node) {
         // has the right node, the successor is the most left node of its right node
        if(node.right != null){
            Node cur = node.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
        // no right node, find its prarent that bigger than the node
        Node cur = node;
        while(cur.parent != null && node.val >= cur.val){
            cur = cur.parent;
        }
        if(cur.val > node.val){
            return cur;
        }
        // no successor
        return null;
    }
}
