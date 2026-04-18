/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newListHead = null, start = head;
        HashMap<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(null, null);
        
        while(start != null) {
            newListHead = new Node(start.val);
            nodeMap.put(start, newListHead);
            start = start.next;
        }

        start = head;
        while(start != null) {
            Node temp = nodeMap.get(start);
            temp.next = nodeMap.get(start.next);
            temp.random  = nodeMap.get(start.random);
            start = start.next;
        }

        return nodeMap.get(head);
    }
}
