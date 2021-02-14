class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node c1 = head;
        Node dummy = new Node(-1);
        Node c2 = dummy;
        while(c1 != null){
            Node temp = null;
            if(!map.containsKey(c1)){
                map.put(c1, new Node(c1.val));
            }
            temp = map.get(c1);
            if(c1.next != null){
                Node next = c1.next;
                if(!map.containsKey(next)){
                    map.put(next, new Node(next.val));
                }
                temp.next = map.get(next);
            }
            if(c1.random != null){
                Node ran = c1.random;
                if(!map.containsKey(ran)){
                    map.put(ran, new Node(ran.val));
                }
                temp.random = map.get(ran);
            }
            c2.next = temp;
            c2 = c2.next;
            c1 = c1.next;
        }
        return dummy.next;
    }
}
