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
    public ListNode deleteDuplicates(ListNode head) {
        while(head!=null && head.next!=null && head.next.val==head.val){
        while(head.next!=null && head.next.val==head.val){
            head=head.next;
        }
        head=head.next;
        }
        ListNode curr=head,prev=null;
        while(curr!=null && curr.next!=null){
            if(curr.next.val==curr.val){
                 while(curr!=null && curr.next!=null && curr.next.val==curr.val){
                    curr=curr.next;
                 }
                 curr=curr.next;
                 prev.next=curr;
            }else{
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}