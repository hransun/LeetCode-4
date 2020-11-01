class Codec {
    // Encodes an n-ary tree to a binary tree.
    //   1                 1
    //  | | |     ->        \
    //  2 3 4                2
    //                       /
    //                      3
    //                      /
    //                     4
   //left child 接 root的一下层， right child 接 root的当前层的node
    public TreeNode encode(Node root) {
        if(root == null){
            return root;
        }
        TreeNode res = new TreeNode(root.val);
        if(root.children.size() != 0){
            res.left = encode(root.children.get(0));
        }
        TreeNode cur = res.left;
        for(int i = 1; i < root.children.size(); i++){
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null){
            return root;
        }
        Node res = new Node(root.key, new ArrayList<>());
        //cur移到下一层
        TreeNode cur = res.left;
        while(cur != null){
            //recusrion，返回每一个子树的root节点
            res.children.add(decode(cur));
            //走right 去找当前层的child
            cur = cur.right;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
