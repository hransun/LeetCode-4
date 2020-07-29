class LFUCache {
//priorityqueue keep the node
//Map<key, Node>
//Node<key, value, time, order>
    static class Node {
            int key;
            int value;
            int time;
            int order;
            Node(int key, int value, int time,int order){
                this.value = value;
                this.time = time;
                this.key = key;
                this.order = order;
            }
        }
        Map<Integer, Node> map;
        PriorityQueue<Node> pq;
        int size;
        int order;
        public LFUCache (int capacity) {
            map = new HashMap<>();
            pq = new PriorityQueue<>(new MyCompare());
            size = capacity;
            order = 0;
        }
        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Node node = updatePq(key,map.get(key).value);
            return node.value;
        }
//T: nlogn
        public void put(int key, int value) {
            if(size == 0) {
                return;
            }
            if(map.containsKey(key)) {
                updatePq(key,value);
                return;
            }
            if(pq.size() == size) {
                Node old = pq.poll();
                map.remove(old.key);
            }
            Node node = new Node(key,value, 1,order++);
            map.put(key, node);
            pq.offer(node);
        }
        private Node updatePq(int key,int value) {
            Node node = map.get(key);
            pq.remove(node);
            Node newNode = new Node(key, value, node.time+1,order++);
            pq.offer(newNode);
            map.put(key, newNode);
            return newNode;
        }
        private static class MyCompare implements Comparator<Node> {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.time == n2.time && n1.order == n2.order) {
                    return 0;
                }
                if(n1.time == n2.time && n1.order < n2.order) {
                    return -1;
                }
                return n1.time < n2.time? -1: 1;
            }
        }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
