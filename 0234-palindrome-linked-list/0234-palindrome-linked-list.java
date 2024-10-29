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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        ArrayDeque<Integer> s = new ArrayDeque<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (size % 2 != 0) {
            slow = slow.next;
        }
        while (slow != null && !s.isEmpty()) {
            if (slow.val != s.peek()) {
                return false;
            }
            slow = slow.next;
            s.pop();
        }
        if(slow==null && s.isEmpty()){
            return true;
        }
        return false;
    }
}