class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        new ListNode(-1, -1, null);
    }
}
class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++)
            map[i] = new ListNode();
    }
    
    public void put(int key, int value) {
        ListNode headNode = map[key % map.length];
        while (headNode.next != null) {
            if (headNode.next.key == key) {
                headNode.next.val = value;
                return;
            }
            headNode = headNode.next;
        }
        
        headNode.next = new ListNode(key, value, null);
    }
    
    public int get(int key) {
        ListNode headNode = map[key % map.length].next;
        while(headNode != null) {
            if (headNode.key == key)
                return headNode.val;
            headNode = headNode.next;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        ListNode headNode = map[key % map.length];
        while (headNode.next != null) {
            if(headNode.next.key == key) {
                headNode.next = headNode.next.next;
                return;
            }
            headNode = headNode.next;
        }

    }

    private int hash(int key) {
        return key % map.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */