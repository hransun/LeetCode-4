/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        //从leaf出发，往他的leftnode 走
        Node cur = leaf;
        Node prev = null;
        while(cur != root){
            Node parent = cur.parent;
            //if cur has a left child, then that child becomes cur's right child.
            if(cur.left != null){
                cur.right = cur.left;
            }
            //cur's original parent becomes cur's left child
            cur.left = parent;
            // cut the parent's connection
            if(parent.left == cur){
                parent.left = null;
            }else{
                parent.right = null;
            }
            //reconneting with new parent points
             cur.parent = prev;
            // move for the next interation
            prev = cur;
            cur = cur.left;
        }
        // point the root.parent to the prev
        root.parent = prev;
        return leaf;
    }
}
