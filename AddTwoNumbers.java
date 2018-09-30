/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode((l1.val + l2.val)%10);
        ListNode sumCur = sum;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = (l1.val + l2.val) / 10;
        while (cur1.next != null || cur2.next != null || carry == 1) {
            if (cur1.next == null && cur2.next == null) {
                sumCur.next = new ListNode(1);
                sumCur = sumCur.next;
                break;
            } else if (cur1.next == null) {
                cur2 = cur2.next;
                sumCur.next = new ListNode((cur2.val + carry) % 10);
                sumCur = sumCur.next;
                carry = (cur2.val + carry) / 10;
            } else if (cur2.next == null) {
                cur1 = cur1.next;
                sumCur.next = new ListNode((cur1.val + carry) % 10);
                sumCur = sumCur.next;
                carry = (cur1.val + carry) / 10;
            } else {
                cur1 = cur1.next;
                cur2 = cur2.next;
                sumCur.next = new ListNode((cur1.val + cur2.val + carry) % 10);
                sumCur = sumCur.next;
                carry = (cur1.val + cur2.val + carry)/10;
            }
        }
        return sum;
    }
}