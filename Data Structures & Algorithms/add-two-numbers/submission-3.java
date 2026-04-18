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
        int carry = 0, curDigitValue;
        ListNode sumHead = null, sumHolder = null, currentSumHolder = null;
        while(l1 != null || l2 != null) {
            curDigitValue = carry;

            if (l1 != null) curDigitValue += l1.val;
            if (l2 != null) curDigitValue += l2.val;

            carry = curDigitValue / 10;
            curDigitValue = curDigitValue % 10;

            if (sumHead == null) {
                sumHead = new ListNode(curDigitValue);
                sumHolder = sumHead;
            } else {
                sumHolder.next = new ListNode(curDigitValue);
                sumHolder = sumHolder.next;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry != 0)
            sumHolder.next = new ListNode(carry);
        
        return sumHead;
    }
}
