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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        
        int maxLength = 0;
        ListNode head = null, temp = null;
        while (true) {
            int curMinValue = Integer.MAX_VALUE, curMinIndex = 0, curNullCount = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    curNullCount++;
            }

            if (curNullCount == lists.length)
                break;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < curMinValue) {
                    curMinValue = lists[i].val;
                    curMinIndex = i;
                }
            }

            if (head == null) {
                head = new ListNode(curMinValue);
                temp = head;
            } else {
                temp.next = new ListNode(curMinValue);
                temp = temp.next;
            }

            lists[curMinIndex] = lists[curMinIndex].next;
        }

        return head;
    }
}
