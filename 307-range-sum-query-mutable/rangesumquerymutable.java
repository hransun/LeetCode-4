class NumArray {
    //create the segmenttree class
    private static class SegmentTree{
        int val;
        SegmentTree left;
        SegmentTree right;
        //后续会初始化
        // SegementTree(int val) {
        //     this.val = val;
        // }
    }

    SegmentTree root;
    int depth;
        //一开始所有的treenode 值都是null,即“0”
        //只有碰到需要更新的node值，才建立node
    int getValue(SegmentTree node) {
        return node == null? 0: node.val;
    }
    SegmentTree getChildL(SegmentTree node) {
        return node == null? null : node.left;
    }
    SegmentTree getChildR(SegmentTree node) {
        return node == null? null : node.right;
    }
    //初始化segemnt tree
    public NumArray(int[] nums) {
        //左右要加2个0 node
        //算出tree的树高
        // getExponent 结果是float -> int (towards 0)
        // 需要额外+1
        depth = Math.getExponent(nums.length+2) + 1;
        for(int i  = 0; i < nums.length;i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        //跟新root节点的值以及他对应的一系列的parent node
        // 1<<depth ==》叶子的总个数
        //1<< (depth-1) --> 计算左子树的node个数
        //由于左右都各加了1，index需要右移1
        root = updateNode(root, 1<<(depth-1)?,i+1,val);
    }
    //sizeL: 左子树的node个数
    private SegmentTree updateNode(SegmentTree node, int sizeL, int index, int val) {
        //说明之前这个node没有走到过
        if(node == null) {
            node = new SegmentTree();
        }
        //左边没有叶子数量，直接new一个新的node
        if(sizeL == 0) {
            node.val = val;
            return node;
        }
        //index < the number of leaf nonds --> go left?
        if(index < sizeL) {
            //每一层的子树数量比上一层少一半
            node.left = updateNode(node.left, sizeL/2, index, val);
            // index > the numbe or leaf nodes --> go right, and update index
        }else{
            node.right = updateNode(node.right, sizeL/2, index-sizeL, val);
        }
        //node值更新为左右子树的值相加
        node.val = getValue(node.left) + getValue(node.right);
        return node;
    }

    public int sumRange(int i, int j) {
        // i, j ==> (i-1, j+1)
        //i，j左右各加两个0 ==>(i+1-1, j+1+1)
        return sumNode(root, root, 1 <<(depth-1), i+1-1, j+1+1);
    }
    //nodeL = p nodeR = q
    private int sumNode(SegmentTree nodeL, SegmentTree nodeR, int sizeL, int indexL, int indexR) {
        //补0的情况，
        if(sizeL == 0) {
            return 0;
        }
        //下一层pointer
        SegmentTree nextL;
        SegmentTree nextR;
        int ans = 0;
        //p pointer 如何走
         //index < the number of leaf nonds --> go left?
        if(indexL < sizeL) {
            //两个pointer不指向一个节点
            if(nodeL != nodeR) {
                //往左走，累计他的右兄弟
                ans += getValue(getChildR(nodeL));
            }
                //pointer指向左node
            nextL = getChildL(nodeL);
            //往右走，跟新indexL
            // index > the numbe or leaf nodes --> go right, and update index?
        } else{
                nextL = getChildR(nodeL);
                indexL -= sizeL;?
        }
        //q pointer 如何走
        if(indexR < sizeL){
            nextR = getChildL(nodeR);
        }else{
            //q pointer往右走,累计他的右兄弟
            if(nodeL != nodeR) {
                ans += getValue(getChildL(nodeR));
            }
            nextR = getChildR(nodeR);
            indexR -= sizeL;
        }
        return ans + sumNode(nextL, nextR, sizeL/2, indexL, indexR);

    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
