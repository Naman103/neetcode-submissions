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
        int totalCount = 0;
        while(start != null) {
            start = start.next;
            totalCount++;
        }

        System.out.println(totalCount);
        
        ListNode current = head, prev = null;
        int count = 0;
        while(count != totalCount - n) {
            ListNode temp = current;
            current = current.next;
            prev = temp;
            count++;
        }

        //remove current
        if(prev != null)
            prev.next = current.next;
        else 
            head = current.next;
        return head;

    }
}
