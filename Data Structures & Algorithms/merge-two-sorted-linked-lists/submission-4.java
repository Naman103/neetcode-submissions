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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        ListNode mergedNode = new ListNode();
        ListNode headNode = mergedNode;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                mergedNode.val = list1.val;
                list1 = list1.next;
            } else {
                mergedNode.val = list2.val;
                list2 = list2.next;
            }

            if(list1 != null || list2 != null) {
            mergedNode.next = new ListNode();
            mergedNode = mergedNode.next;
            }
        }

        while(list1 != null) {
                mergedNode.val = list1.val;
                list1 = list1.next;

            if (list1 != null) {
            mergedNode.next = new ListNode();
            mergedNode = mergedNode.next;
            }
        }


        while(list2 != null) {
                mergedNode.val = list2.val;
                list2 = list2.next;

            if (list2 != null) {
            mergedNode.next = new ListNode();
            mergedNode = mergedNode.next;
            }
        }

        return headNode;
    }
}