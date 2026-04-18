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
    public void reorderList(ListNode head) {
        ListNode last = reverseSecondHalf(head);
        ListNode start = head;
        ListNode temp;
        while(last != null && last.next != null) {
            temp = start.next;
            start.next = last;
            start = temp;
            temp = last.next;
            last.next = start;
            last = temp;
        }
    }

    private ListNode reverseSecondHalf(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return reverseList(slow);
    }

    private ListNode reverseList(ListNode current) {
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
