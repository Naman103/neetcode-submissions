/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        int length = 0;
        while(start != null) {
            start = start.next;
            length++;
        }

        int posFromStart = length - n - 1;
        length = 0;
        start = head;
        if (posFromStart == -1)
            return head.next;
        
        while(start != null) {
            if (length == posFromStart) {
                start.next = start.next.next;
                break;
            }
            length++;
            start = start.next;
        }
        return head;
    }
}
