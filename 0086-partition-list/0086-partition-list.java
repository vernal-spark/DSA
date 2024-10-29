/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head, prev = null;
        while (curr != null && curr.val < x) {
            prev = curr;
            curr = curr.next;
        }
        while (curr != null && curr.next != null) {
            if (curr.next.val < x) {
                ListNode temp = curr.next.next;
                if (prev != null) {
                    curr.next.next = prev.next;
                    prev.next = curr.next;
                    prev=curr.next;
                    curr.next = temp;
                } else {
                    curr.next.next = head;
                    head = curr.next;
                    prev=head;
                    curr.next = temp;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}