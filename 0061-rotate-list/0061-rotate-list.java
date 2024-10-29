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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = 0;
        ListNode curr = head,prev;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        if(k>size){
            k%=size;
        }
        while(k>0){
            curr = head;
            prev = null;
            while(curr.next!=null){
                prev = curr;
                curr = curr.next;
            }
            curr.next = head;
            head = curr;
            prev.next = null;
            k--;
        }
        return head;
    }
}