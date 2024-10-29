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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode n1=head,n2 = head,prev=null;
        while(n1!=null && n2!=null && n2.next!=null){
            prev=n1;
            n1=n1.next;
            n2=n2.next.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}