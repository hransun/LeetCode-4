class Solution {
    public Node findRoot(List<Node> tree) {
        //给你一个打乱顺序的node tree， 已list的形式表示，找到起parent root
        // 读一个node， val++， 读一个children node， val--
        //最后剩余的val即root的val
        int val = 0;
        for(Node node:tree){
            val += node.val;
            for(Node child: node.children) {
                val -= child.val;
            }
        }
        for(Node node: tree){
            if(node.val == val){
                return node;
            }
        }
        return null;
    }
}
