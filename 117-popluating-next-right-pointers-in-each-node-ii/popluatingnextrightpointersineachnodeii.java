/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node leftMost = root;
        while(leftMost != null){
            //当前层的最右边开始
            Node cur = leftMost;
            //其实上一个right node == null
            Node lastRight = null;
            //遍历这一次的node
            while(cur != null){
                Node left = cur.left;
                Node right = cur.right;
                //如果下一层没有子node，直接跳过
                if(left == null && right == null){
                    cur = cur.next;
                    continue;
                }
                //有left node
                if(left != null){
                    //如果右边有node，建立链接
                    if(lastRight != null){
                        lastRight.next = left;
                    }
                    //建立和右边node的链接
                    left.next = right;
                    //跟新最右边的nodepointer
                    lastRight = left;
                }
                //有right node
                if(right != null){
                    //如果他没头left bro并且最右边的rightnode不为null，建立和最右边的node的链接
                    if(left == null && lastRight != null){
                        lastRight.next = right;
                    }
                    //跟新最右边的node的pointer
                    lastRight = right;
                }
                //当前层移动到下一个node
                cur = cur.next;
            }
            //当前层已经遍历完成，进入下一层
            //找到一下层最左边的node
            while(leftMost != null && leftMost.left == null && leftMost.right == null){
                leftMost = leftMost.next;
            }
            //如果下一层还有node，跟新最右边的node，否则返回leftMost指向null
            if(leftMost != null){
                leftMost = leftMost.left != null? leftMost.left: leftMost.right;
            }
        }
        return root;
    }
}
