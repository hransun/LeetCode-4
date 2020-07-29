/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        //case1: cur.child != null && cur.next != null
        //stack.offer(cur.next) ==> 因为cur.next要指向child了
        //case2: cur.next == null && !stack.isEmpty()
        // cur.next = stack.poll() == > cur走到头了，要和上一次的next链接在一起
        //T: O(n) S:O(n)
        if(head == null) {
            return head;
        }
        Node cur = head;
        Deque<Node> stack = new ArrayDeque<>();
        while(cur != null) {
            if(cur.child != null) {
                // if cur has next
                if(cur.next != null){
                    stack.offerFirst(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                //走到末尾
            }else if(cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pollFirst();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
