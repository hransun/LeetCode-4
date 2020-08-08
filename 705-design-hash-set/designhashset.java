class MyHashSet {
    class Node{
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }
    /** Initialize your data structure here. */
    Node[] array;
    int size;
    public MyHashSet() {
       array = new Node[317];
       size= 0;

    }
    private int hash(int key) {
        return key%317;
    }
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        int index = hash(key);
        Node node = new Node(key);
        Node head = array[index];
        node.next = head;
        array[index] = node;
        size++;
    }

    public void remove(int key) {
       if(!contains(key)) {
            return;
        }
       int index = hash(key);
       Node head = array[index];
       Node pre = null;
       while(head != null) {
           if(head.value == key) {
               if(pre == null){
                   array[index] = head.next;
               }else {
                   pre.next = head.next;
               }
               head.next = null;
               size--;
               return;
           }
       }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
       Node head = array[index];
        while(head != null) {
            if(head.value == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
