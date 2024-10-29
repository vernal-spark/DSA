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
        int count=0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        int pos=count-n;
        if (pos == 0) {
        return head.next;
        }
        curr=head;
        while(pos>1){
            curr=curr.next;
            pos--;
        }
        curr.next=curr.next.next;
        return head;
    }
}