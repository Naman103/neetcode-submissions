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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = reverseList(l1);
        //l2 = reverseList(l2);
        ListNode temp1 = l1;
        
        int carry = 0;
        int digitValue = 0;
        int digitSum = 0;
        ListNode head = null, prevNode = null, current = null;
        while(l1 != null && l2 != null) {
            digitSum = l1.val + l2.val + carry;
            carry = digitSum/10;

            current = new ListNode(digitSum % 10);
            if(head == null)
                head = current;

            if(prevNode != null)
                prevNode.next = current;            
            prevNode = current;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            digitSum = l1.val + carry;
            carry = digitSum/10;
            current = new ListNode(digitSum % 10);
            if(head == null)
                head = current;

            if(prevNode != null)
                prevNode.next = current;            
            prevNode = current;
            l1 = l1.next;
        }

        while(l2 != null) {
            digitSum = l2.val + carry;
            carry = digitSum/10;
            current = new ListNode(digitSum % 10);
            if(head == null)
                head = current;

            if(prevNode != null)
                prevNode.next = current;            
            prevNode = current;
            l2 = l2.next;
        }

        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            prevNode.next = temp;
        }

       //head = reverseList(head);
        return head;
    }

    public ListNode reverseList(ListNode node) {
        ListNode current = node, prev = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
        
    } 
}
