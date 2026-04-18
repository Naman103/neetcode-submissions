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
       Map<Node, Node> copyMap = new HashMap<>();

       Node temp = head;
       while(temp != null) {
            copyMap.put(temp, new Node(temp.val));
            temp = temp.next;
       }

        temp = head;
        while (temp != null) {
            Node copyNode = copyMap.get(temp);
            copyNode.next = copyMap.get(temp.next);
            copyNode.random = copyMap.get(temp.random);
            temp = temp.next;
        }

        return copyMap.get(head);
    }
}
