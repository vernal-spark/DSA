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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next==null || head.next.next==null)return head;
        ListNode t1=head,t2=head.next,curr=head.next.next;
        t2.next=null;
        int currIndex = 1;
        while(curr!=null){
            ListNode temp = curr.next;
            if(currIndex==1){
                curr.next = t1.next;
                t1.next = curr;
                t1=curr;
                currIndex=0;
            }
            else{
                curr.next = null;
                t2.next = curr;
                t2=curr;
                currIndex=1;
            }
            curr=temp;
        }
        return head;
    }
}