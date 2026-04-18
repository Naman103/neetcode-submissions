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
        ListNode start = new ListNode(0);
        start.next = head;
        head = start;
        ListNode first = start;
        for (int i = 0; i < n; i++)
            first = first.next;
        
        while(first.next != null) {
            start = start.next;
            first = first.next;
        }

        start.next = start.next.next;
        return head.next;
    }
}
