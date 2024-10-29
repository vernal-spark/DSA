class LRUCache {
    public class Node {
        int key,val;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private HashMap<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap(capacity);
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            deleteNode(this.map.get(key));
            addToHead(this.map.get(key));
            return Integer.valueOf(this.map.get(key).val);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            deleteNode(this.map.get(key));
            map.remove(this.map.get(key));
            Node newNode = new Node(key,value);
            this.map.put(key,newNode);
            addToHead(newNode);
        } else {
            if(this.map.size() >= this.capacity) {
                Node toDelete = tail.prev;
                map.remove(toDelete.key);
                deleteNode(toDelete);
            }
            Node newNode = new Node(key,value);
            this.map.put(key,newNode);
            addToHead(newNode);
        }
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */