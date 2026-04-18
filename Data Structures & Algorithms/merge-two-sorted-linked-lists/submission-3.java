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
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;
        while(list1 != null && list2 != null) {
            System.out.println("List1 : " + list1.val + " | List2 : " + list2.val);
            if(list1.val < list2.val) {
                mergedList.val = list1.val;
                list1 = list1.next;
            } else {
                mergedList.val = list2.val;
                list2 = list2.next;
            }

            if(list1 != null || list2 != null) {
            mergedList.next = new ListNode();
            mergedList = mergedList.next;
            }
        }

        while(list1 != null) {
            mergedList.val = list1.val;
            list1 = list1.next;
            if(list1 != null) {
            mergedList.next = new ListNode();
            mergedList = mergedList.next;
            }
        }

        while(list2 != null) {
            mergedList.val = list2.val;
            list2 = list2.next;
            if(list2 != null) {
            mergedList.next = new ListNode();
            mergedList = mergedList.next;
            }
        }

        return head;
    }
}